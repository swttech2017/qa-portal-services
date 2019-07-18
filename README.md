[TOC]

#### QA Portal Services

##### Projects

The projects in this repository provide the business logic, service integration and persistence capabilities of the QA Portal application. This repository is split into the following

a) A single library project (api-common) containing code that is likely to be used by all the QA Portal micro-service projects. This should reduce the time to develop new micro-service projects, maximise code reuse and encourage a consistent structure for these micro-service projects. 

b) A number of Spring Boot micro-service projects that make use of the api-common library. Each of these will expose REST endpoints for a specific application domain. These should all make use of the security, exception handling, persistence and mapping functionality provided by the common-api library. These REST endpoints will be accessed by the QA Portal angular client, but could be accessed from any client provided the client is configured with the appropriate keycloak security adapter. 



##### Developer Guide

###### Common Library

The api-common project contains the code that is likely to be used by all the QA Portal micro-service projects, providing the following common functionality

**A security configuration and implementation (Keycloak)**

Keycloak (https://www.keycloak.org/documentation.html), has been selected to provide the authentication mechanism for the QA Portal application. Keycloak is an identity and access management provider with client adapter libraries our applications can use to integrate with the Keycloak provider. For our Spring Boot micro-services this requires a Spring security configuration to integrate with keycloak. This is achieved by the following

a) Including the keycloak spring security dependency in the pom.xml file of the api-common project (and each of the Spring Boot micro-service projects).

b) Create a Keycloak implementation of Spring Security Config (in api-common project). This is provided in the com.qa.portal.common.config.SecurityConfig class. The KeyclockConfigResolver injected into this class returns a keycloak.json file. 

c) keycloak,json file provided in the resources folder of each Spring Boot micro-service project. This specifies the configuration for the Keycloak adapter to connect to the Keycloak provider. 

This configuration can be obtained from the keycloak providers admin console as follows - 

​			Log into the keycloak admin console (http://localhost:8080/auth/admin/)

​			Select the qa-portal realm

​			In Clients option, select the qa-portal-services-core client

​			Select the Installation option (right most option)

​			Select Keycloak OIDC JSON format

​			The JSON configuration will be displayed.

​			Copy and paste this into the keycloak.json file in the resources file. 

**Standard Exception handling mechanism**

Spring Boot provides an Exception Handling mechanism that separates the exception handling from our business code. In the api-common project the com.qa.portal.common.exception.QaPortalExceptionHandler class has been created to provide this central exception handling mechanism. There are a 3 QA Portal Exceptions that should be thrown from our Spring Boot "micro"-services: 

​			QAPortalBusinessException - thrown if we encounter an business validation issue, or an 			error that is recoverable by user action within the application.

​			QaResourceNotFoundException - thrown if an entity (resource) is not found. 

​			QaPortalSevereException - thrown if the application encounters a serious error that user 			action could not resolve (e.g. Out of memory exception, cannot connect to external 			resource (database or service), etc). 

Any Runtime Exceptions will also be handled by the QAPortalExceptionHandler and will be treated by the client in the same way as a QAPortalSevereException.

The current implementation is very basic. The intention is to extend this to source messages from a file external to the application and the facility to insert context information into those messages.

**Optimistic Locking solution**

Optimistic Locking is the standard solution solution for dealing with concurrent updates of database records. It doesn't have the performance impact of pessimistic locking and is simple to implement using JPA annotations.

The com.qa.portal.common.persistence.entity.QaBaseEntity is a mapped superclass (fancy way of saying a superclass of an Entity class with persistence mappings, without itself being an Entity). This class has the following 3 properties

​				last_updated_timestamp

​				last_updated_by

​				version

The version property is decorated with @Version which tells JPA providers that this is the column to use to track the version of the entity instance. Everything else is taken care of by the JPA provider. If an entity cannot be updated due to concurrent access, an OptimisticLockException will be thrown, which will be handled by the central QaPortalExceptionHandler, returning a message to the client advising them to retry the operation. 

Any entities created in the Spring Boot micro-service projects only have to extend this QaBaseEntity class in order to have optimistic locking automatically activated.

**Utility classes**

Dozer provides a facility to map a source object into an object of a target class, by providing XML configuration or using Dozer annotations. For our services we are using the XML configuration mechanism.

A DozerBeanMapper is instantiated in the Spring Boot configuration class com.qa.portal.common.config.CoreConfig, and is injected into the com.qa.portal.common.util.mapper.BaseMapper class. This wraps the DozerBeanMapper class and provides a few convenience methods for mapping QaUserEntity and QaUserDto objects. This could be extended in the future. To support Dozer mappings there are also some custom converters provided in the com.qa.portal.common.util.mapper.converters package.



###### Spring Boot micro-service projects

core-api and self-reflection-api are Qa Portal Spring Boot micro-service projects. These have a standard structure that all Spring Boot projects should adhere to 

a) Spring Boot Application class placed in the com.qa.portal package. Spring Boot component scan will manage all beans that are at (or inside) the Spring Boot applications package. By placing the application class at the com.qa.portal package, all the beans from the api-common library will automatically be accessible from the micro-service application. 

b) Under the com.qa.portal.$proj-name$ package, the following packages should be created

​				config - contains any Spring Boot configuration classes for instantiation of beans for 				this application

​				dto - data transfer objects passed across the wire from client to the service. Ideally 				these should be immutable, but due to auto conversion by Jackson, accessor methods 				are required.

​				persistence - when using JPA broken into entity and repository subpackages. Each 				entity requiring optimistic locking, last_updated_timestamp and last_updated_by 				should extend QABaseEntity. Ensure that all relationships are modelled (i.e. we don't 				want entities with ids representing foreign keys).

​				rest - Spring Boot RestControllers added to this package. The controller classes 				should have no business or exception handling logic, instead just delegating to the 				service classes to carry out the business logic. Exceptions should be handled centrally 				by QaPortalExceptionHandler. 

​				service - all business logic and management of persistence objects (entities) are 				performed by the classes in this package. A service class provides the entry point to 				this business processing, and provides the transaction boundary for the operation. The 				service class method called from a RestController should be decorated with the 				@Transactional annotation. These classes do the the bulk of the processing is so it's 				worth breaking service classes down if there are several operations being performed				by the service. See the self-reflection-api services package for an example where				Operation classes provide the main processing and various mapper classes provide the 				transformation between entity and DTO classes.

​				NOTE: Entity classes should not leak outside the service classes (i.e. should never see 				an Entity class in a DTO, or referenced directly by a Controller.)

c) Each Spring Boot micro-service project must have a dependency in their pom.xml to the api-common library, and the keycloak spring security adapter. By adding a keycloak.json file to the micro-service projects resources folder, keycloak authentication will automatically be activated for all endpoints.



###### Adding a new Spring Boot Project



###### Developing a new Spring Boot micro-service





##### Building and Running Services

###### Pre-Requisites

a) A local keycloak instance and Postgres DB has been installed and configured. See instructions in 
https://github.com/swttech2017/qa-portal-infra/blob/master/README.md

###### Build and Run Core Services

a) Clone the qa-portal-services repo using command

git clone https://github.com/swttech2017/qa-portal-services.git

b) From the base folder build with maven

mvn clean install

c) From the core-api folder start the core-api services as a spring boot application

mvn spring-boot:run

QA Portal Services
---

**Pre-Requisites**

a) A local keycloak instance and Postgres DB has been installed and configured. See instructions in 
https://github.com/swttech2017/qa-portal-infra/blob/master/README.md


**Build and Run Core Services**

a) Clone the qa-portal-services repo using command

https://github.com/swttech2017/qa-portal-services.git

b) From the base folder build with maven

mvn clean install

c) From the core-api folder start the core-api services as a spring boot application

mvn spring-boot:run

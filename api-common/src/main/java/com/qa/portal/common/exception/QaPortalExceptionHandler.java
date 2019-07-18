package com.qa.portal.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class QaPortalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(QaPortalExceptionHandler.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(QaResourceNotFoundException.class)
    public ResponseEntity<?> handle(QaResourceNotFoundException e, WebRequest request) {
        LOGGER.error("Not Found QA Exception handler " + e.getMessage(), e);
        return handleExceptionInternal(e, getMessage(e, request), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(QaPortalSevereException.class)
    public ResponseEntity<?> handle(QaPortalSevereException e,  WebRequest request) {
        LOGGER.error("Internal Server Error QA Exception handler " + e.getMessage(), e);
        return handleExceptionInternal(e, getMessage(e, request),  new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(QaPortalBusinessException.class)
    public ResponseEntity<?> handle(QaPortalBusinessException e,  WebRequest request) {
        LOGGER.error("Bad Request QA Exception handler " + e.getMessage(), e);
        return handleExceptionInternal(e, getMessage(e, request),  new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handle(RuntimeException e,  WebRequest request) {
        LOGGER.error("Runtime Exception handler " + e.getMessage(), e);
        return handleExceptionInternal(e, e.getMessage(),  new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    // TODO - Exception handling mechanism with messages from external file and inserts
    private String getMessage(RuntimeException e, WebRequest request) {
        return e.getMessage();
    }
}

package com.wsb.library2;

import com.wsb.library2.exception.ResourceNotFoundException;
import com.wsb.library2.exception.ResourceUnavailable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationControllerAdvice.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle(ResourceNotFoundException ex) {
        LOGGER.warn("Something went wrong: {}", ex.getMessage(), ex);
        return "resourceNotFound";
    }

    @ExceptionHandler(ResourceUnavailable.class)
    public  String handle(ResourceUnavailable ex) {
        LOGGER.warn("Something went wrong: {}", ex.getMessage(), ex);
        return "resourceUnavailable";
    }

}

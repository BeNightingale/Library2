package com.wsb.library2;

import com.wsb.library2.exception.ResourceNotFoundException;
import com.wsb.library2.exception.ResourceUnavailable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApplicationControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationControllerAdvice.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handle(ResourceNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("resourceException");
        modelAndView.addObject("message", ex.getMessage());
        LOGGER.warn("Something went wrong: {}", ex.getMessage(), ex);
        return modelAndView;
    }

    @ExceptionHandler(ResourceUnavailable.class)
    public ModelAndView handle(ResourceUnavailable ex) {
        ModelAndView modelAndView = new ModelAndView("resourceException");
        LOGGER.warn("Something went wrong: {}", ex.getMessage(), ex);
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}

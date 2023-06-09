package com.folcademy.clinica.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> defaultErrorHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("Error Generico", e.getMessage(),"1", req.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> notFoundHandler(HttpServletRequest req, Exception e) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("Not Found", e.getMessage(),"2", req.getRequestURI()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> badRequestHandler(HttpServletRequest req, Exception e) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("Bad Request", e.getMessage(),"3", req.getRequestURI()), HttpStatus.BAD_REQUEST);
    }
}

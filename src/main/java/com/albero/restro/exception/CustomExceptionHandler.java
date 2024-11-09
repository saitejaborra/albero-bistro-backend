package com.albero.restro.exception;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> throwRuntime( RuntimeException ex){
        Map<String, String> map= new HashMap<>();
        log.info("entered unchecked block");
        map.put("message", ex.getMessage());
        map.put("status", HttpStatus.BAD_REQUEST.toString());
        map.put("status code", String.valueOf(HttpStatus.BAD_REQUEST.value()));
        return ResponseEntity.status(400).body(map);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> throwRuntime( Exception ex){
        Map<String, String> map= new HashMap<>();
        log.info("entered unchecked block");
        map.put("message", ex.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        map.put("status code", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return ResponseEntity.status(500).body(map);
    }

    @ExceptionHandler(MailAuthenticationException.class)
    public ResponseEntity<Map<String, String>> throwMessaging(MailAuthenticationException ex){
        Map<String, String> map= new HashMap<>();
        map.put("message", ex.getMessage());
        log.info("entered this block");
        map.put("status", HttpStatus.UNAUTHORIZED.toString());
        map.put("status code", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        return ResponseEntity.status(404).body(map);
    }
}

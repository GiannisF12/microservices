package com.giannisf12.exception;

import com.giannisf12.payload.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> ExceptionHandler(Exception ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                request.getDescription(false), LocalDateTime.now()
        );
        return ResponseEntity.ok(response);
    }
}

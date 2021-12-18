package com.trianasalesianos.edu.TrianaTourist.errors;

import com.trianasalesianos.edu.TrianaTourist.errors.exceptions.EntityNotFoundException;
import com.trianasalesianos.edu.TrianaTourist.errors.models.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    public final ResponseEntity<Object> buildApiError(Exception ex, WebRequest webRequest){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), ((ServletWebRequest)webRequest).getRequest().getRequestURI()));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildApiError(ex,request);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(EntityNotFoundException entityNotFoundException, WebRequest webRequest){
        return buildApiError(entityNotFoundException,webRequest);
    }


}

package com.indah.freshGoodiesBackend.exception;

import com.indah.freshGoodiesBackend.responses.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Response<Object>> handleApplicationException(ApplicationException ex) {
        log.error(ex.getMessage(), ex);
        return Response.failedResponse(ex.getHttpStatus().value(), ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<List<String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        log.error("Validation errors: {}", errors);
        return Response.failedResponse(HttpStatus.BAD_REQUEST.value(), "Validation failed", errors);
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Response<String>> handleAllExceptions(Exception ex) {
        log.error(ex.getMessage(), ex);

        if (ex.getCause() instanceof UnknownHostException) {
            return Response.failedResponse(HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
        }

        return Response.failedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "We are unable to process your request at this time, please try again later.", ex.getMessage());
    }


}

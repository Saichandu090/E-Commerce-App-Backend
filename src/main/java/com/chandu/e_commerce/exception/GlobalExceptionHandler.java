package com.chandu.e_commerce.exception;

import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<JSONResponseDTO> runTimeException(RuntimeException exception)
    {
        return new ResponseEntity<>(new JSONResponseDTO(false,exception.getMessage(),null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<JSONResponseDTO> productNotFound(ProductNotFoundException exception)
    {
        return new ResponseEntity<>(new JSONResponseDTO(false,exception.getMessage(),null),HttpStatus.BAD_REQUEST);
    }
}

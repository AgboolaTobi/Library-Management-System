package com.SemicolonLibrarySystem.SemicolonLibrary.exceptions;

import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<ApiResponse> registrationException(RegistrationException registrationException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(registrationException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookCatalogException.class)
    public ResponseEntity<ApiResponse> bookCatalogException(BookCatalogException bookCatalogException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(bookCatalogException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<ApiResponse> userRegistrationException(UserRegistrationException userRegistrationException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(userRegistrationException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookCreationException.class)
    public ResponseEntity<ApiResponse> bookCreationException(BookCreationException bookCreationException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(bookCreationException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }
}

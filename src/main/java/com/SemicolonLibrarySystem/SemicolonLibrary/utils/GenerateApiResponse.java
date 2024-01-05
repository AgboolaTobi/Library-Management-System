package com.SemicolonLibrarySystem.SemicolonLibrary.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {

    public static final String INVALID_REGISTRATION_DETAILS = "Invalid details";
    public static final String REGISTRATION_SUCCESSFULLY_COMPLETED = "Congratulations! Your registration is successfully completed";
    public static final String INVALID_STAFF_NUMBER = "Invalid staff number";
    public static final String CATALOG_SUCCESSFULLY_CREATED = "Book catalog successfully created";

    public static ApiResponse created(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }

}

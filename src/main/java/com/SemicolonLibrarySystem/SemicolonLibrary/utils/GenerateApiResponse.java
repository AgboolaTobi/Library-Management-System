package com.SemicolonLibrarySystem.SemicolonLibrary.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {

    public static final String INVALID_REGISTRATION_DETAILS = "Invalid details";
    public static final String REGISTRATION_SUCCESSFULLY_COMPLETED = "Congratulations! Your registration is successfully completed";
    public static final String INVALID_STAFF_NUMBER = "Invalid staff number";
    public static final String CATALOG_SUCCESSFULLY_CREATED = "Book catalog successfully created";
    public static final String INVALID_STUDENT_NUMBER = "The submitted student number is invalid";
    public static final String STUDENT_LIBRARY_REGISTRATION_SUCCESSFULLY_COMPLETED = "Student library registration successfully completed";
    public static final String BOOK_CATALOG_NOT_FOUND = "No book catalog found for this librarian";
    public static final String BOOK_ALREADY_EXIST_IN_CATALOG = "Book already found in catalog";
    public static final String BOOK_SUCCESSFULLY_ADDED_TO_CATALOG = "Book successfully added to catalog";
    public static final String BOOK_NOT_AVAILABLE_AT_THE_MOMENT = "Book not available on the catalog at the moment. Kindly check back later";
    public static final String BOOK_SUCCESSFULLY_ADDED_TO_DESK = "You have successfully requested to borrow this book";
    public static final String STUDENT_DESK_NOT_FOUND = "Student desk not found for this student";
    public static final String BOOK_NOT_FOUND_ON_DESK = "This book is not found on student borrow request at the moment";
    public static final String BOOK_SUCCESSFULLY_REMOVED_FROM_STUDENT_DESK = "You have successfully removed book from list of books on borrow request";
    public static final String BOOK_NOT_FOUND_ON_CATALOG = "The selected book is not available on your catalog at the moment";
    public static final String BOOK_SUCCESSFULLY_DELETED_FROM_CATALOG = "You have successfully removed book from the catalog.";

    public static ApiResponse created(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse added(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();
    }
    public static ApiResponse removed(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();
    }

}

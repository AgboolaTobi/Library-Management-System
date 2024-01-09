package com.SemicolonLibrarySystem.SemicolonLibrary.controllers.userController;

import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.UserBorrowBookRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCatalogException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.user.UserBorrowBookService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/library/")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class UserBorrowBookController {
    private final UserBorrowBookService userBorrowBookService;

    @PostMapping("borrowBook")
    public ResponseEntity<ApiResponse> borrowBook(@RequestBody UserBorrowBookRequest userBorrowBookRequest) throws RegistrationException, BookCatalogException {
        return new ResponseEntity<>(userBorrowBookService.userBorrowBook(userBorrowBookRequest), HttpStatus.OK);
        
    }
}

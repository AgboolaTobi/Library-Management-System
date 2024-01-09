package com.SemicolonLibrarySystem.SemicolonLibrary.controllers.userController;

import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.UserRemoveBookRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCreationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.user.UserRemoveBookService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/library/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserRemoveBookController {
    UserRemoveBookService userRemoveBookService;
    @PostMapping("removeBookFromDesk")
    public ResponseEntity<ApiResponse> removeBookFromDesk(@RequestBody UserRemoveBookRequest userRemoveBookRequest) throws RegistrationException, BookCreationException {

        return new ResponseEntity<>(userRemoveBookService.removeBook(userRemoveBookRequest), HttpStatus.OK);
    }
}

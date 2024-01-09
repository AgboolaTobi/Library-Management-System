package com.SemicolonLibrarySystem.SemicolonLibrary.controllers.userController;

import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.UserRegistrationRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.UserRegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.user.UserCreationService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/library/")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class UserRegistrationController {

    private final UserCreationService userCreationService;

    @PostMapping("registerUser")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) throws UserRegistrationException {

        return new ResponseEntity<>(userCreationService.registerUser(userRegistrationRequest), HttpStatus.CREATED);
    }
}

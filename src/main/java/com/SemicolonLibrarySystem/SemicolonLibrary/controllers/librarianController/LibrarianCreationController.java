package com.SemicolonLibrarySystem.SemicolonLibrary.controllers.librarianController;

import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.LibrarianCreationRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.llibrarian.LibrarianCreationService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/library/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class LibrarianCreationController {

    private final LibrarianCreationService librarianCreationService;

    @PostMapping("registerLibrarian")
    public ResponseEntity<ApiResponse> registerLibrarian(@RequestBody LibrarianCreationRequest librarianCreationRequest) throws RegistrationException {
        return new ResponseEntity<>(librarianCreationService.registerLibrarian(librarianCreationRequest), HttpStatus.CREATED);
    }
}

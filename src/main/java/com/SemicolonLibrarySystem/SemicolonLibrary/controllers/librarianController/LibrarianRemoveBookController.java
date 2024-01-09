package com.SemicolonLibrarySystem.SemicolonLibrary.controllers.librarianController;

import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.LibrarianRemoveBookRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCatalogException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.llibrarian.LibrarianRemoveBookService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/library/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class LibrarianRemoveBookController {
    private final LibrarianRemoveBookService librarianRemoveBookService;
    @PostMapping("removeBookFromBookCatalog")
    public ResponseEntity<ApiResponse> removeBookFromBookCatalog(@RequestBody LibrarianRemoveBookRequest librarianRemoveBookRequest) throws RegistrationException, BookCatalogException {

        return new ResponseEntity<>(librarianRemoveBookService.removeBookFromCatalog(librarianRemoveBookRequest), HttpStatus.OK);

    }
}

package com.SemicolonLibrarySystem.SemicolonLibrary.controllers.bookCreationController;

import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCatalogException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCreationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.book.BookCreationService;
import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.BookCreationRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/library/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class BookCreationController {
    private final BookCreationService bookCreationService;
    @PostMapping("addBookToCatalog")
    public ResponseEntity<ApiResponse> createBook(@RequestBody BookCreationRequest bookCreationRequest) throws RegistrationException, BookCatalogException, BookCreationException {
        return new ResponseEntity<>(bookCreationService.createBook(bookCreationRequest), HttpStatus.CREATED);
    }
}

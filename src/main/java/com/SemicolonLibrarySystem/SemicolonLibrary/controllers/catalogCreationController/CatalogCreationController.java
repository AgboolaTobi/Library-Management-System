package com.SemicolonLibrarySystem.SemicolonLibrary.controllers.catalogCreationController;

import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.BookCatalogCreationRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCatalogException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.bookCatalog.BookCatalogCreationService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/library/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CatalogCreationController {
    private final BookCatalogCreationService bookCatalogCreationService;

    @PostMapping("createCatalog")
    public ResponseEntity<ApiResponse> createCatalog(@RequestBody BookCatalogCreationRequest bookCatalogCreationRequest) throws BookCatalogException {

        return new ResponseEntity<>(bookCatalogCreationService.createBookCatalog(bookCatalogCreationRequest), HttpStatus.CREATED);

    }
}

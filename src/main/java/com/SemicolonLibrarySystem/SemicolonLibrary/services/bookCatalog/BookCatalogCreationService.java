package com.SemicolonLibrarySystem.SemicolonLibrary.services.bookCatalog;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.BookCatalog;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Librarian;
import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.BookCatalogCreationRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCatalogException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.llibrarian.LibrarianService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BookCatalogCreationService {

    private final BookCatalogService bookCatalogService;
    private final LibrarianService librarianService;

    public ApiResponse createBookCatalog(BookCatalogCreationRequest bookCatalogCreationRequest) throws BookCatalogException {
        Librarian librarian = librarianService.findByStaffNumber(bookCatalogCreationRequest.getStaffNumber());
        if (librarian == null) throw new BookCatalogException(GenerateApiResponse.INVALID_STAFF_NUMBER);

        BookCatalog bookCatalog = new BookCatalog();

        bookCatalog.setCatalogNumber(bookCatalogCreationRequest.getCatalogNumber());
        bookCatalog.setStaffNumber(bookCatalogCreationRequest.getStaffNumber());

        BookCatalog savedCatalog = bookCatalogService.save(bookCatalog);

        librarian.setBookCatalog(savedCatalog);
        librarianService.save(librarian);

        return GenerateApiResponse.created(GenerateApiResponse.CATALOG_SUCCESSFULLY_CREATED);
    }
}

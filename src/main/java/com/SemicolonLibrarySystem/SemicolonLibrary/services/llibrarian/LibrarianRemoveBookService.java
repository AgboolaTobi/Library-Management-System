package com.SemicolonLibrarySystem.SemicolonLibrary.services.llibrarian;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Book;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.BookCatalog;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Librarian;
import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.LibrarianRemoveBookRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCatalogException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.book.BookService;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.bookCatalog.BookCatalogService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LibrarianRemoveBookService {

    private final LibrarianService librarianService;
    private final BookCatalogService bookCatalogService;
    private final BookService bookService;

    public ApiResponse removeBookFromCatalog(LibrarianRemoveBookRequest librarianRemoveBookRequest) throws RegistrationException, BookCatalogException {
        Librarian librarian = librarianService.findByStaffNumber(librarianRemoveBookRequest.getStaffNumber());
        if (librarian ==null) throw new RegistrationException(GenerateApiResponse.INVALID_STAFF_NUMBER);
        BookCatalog librarianCatalog = librarian.getBookCatalog();

        if (librarianCatalog == null) throw new BookCatalogException(GenerateApiResponse.BOOK_CATALOG_NOT_FOUND);
        Book bookOnCatalog = bookService.findByBookName(librarianRemoveBookRequest.getBookName());

        if (bookOnCatalog == null) throw new BookCatalogException(GenerateApiResponse.BOOK_NOT_FOUND_ON_CATALOG);

        List<Book> listOfBooksOnCatalog = librarianCatalog.getListOfBooks();

        listOfBooksOnCatalog.remove(bookOnCatalog);

        librarianCatalog.setListOfBooks(new ArrayList<>(listOfBooksOnCatalog));

        BookCatalog updatedCatalog = bookCatalogService.save(librarianCatalog);

        librarian.setBookCatalog(updatedCatalog);
        librarianService.save(librarian);

        return GenerateApiResponse.removed(GenerateApiResponse.BOOK_SUCCESSFULLY_DELETED_FROM_CATALOG);
    }
}

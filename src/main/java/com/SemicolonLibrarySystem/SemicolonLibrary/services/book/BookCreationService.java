package com.SemicolonLibrarySystem.SemicolonLibrary.services.book;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.enums.BookCategory;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Book;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.BookCatalog;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Librarian;
import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.BookCreationRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCatalogException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.BookCreationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.bookCatalog.BookCatalogService;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.llibrarian.LibrarianService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookCreationService {

    private final LibrarianService librarianService;
    private final BookService bookService;
    private final BookCatalogService bookCatalogService;
    private final ModelMapper mapper;

    public ApiResponse createBook(BookCreationRequest bookCreationRequest) throws BookCreationException, BookCatalogException, RegistrationException {

        Librarian librarian = librarianService.findByStaffNumber(bookCreationRequest.getStaffNumber());
        if (librarian==null) throw new RegistrationException(GenerateApiResponse.INVALID_STAFF_NUMBER);

        BookCatalog bookCatalog = librarian.getBookCatalog();
        if (bookCatalog.getCatalogNumber()==null) throw new BookCatalogException(GenerateApiResponse.BOOK_CATALOG_NOT_FOUND);

        List<Book> listOfBook = bookCatalog.getListOfBooks();
        if (listOfBook==null){
            listOfBook = new ArrayList<>();
        }
        Book existingBook = bookService.findByBookName(bookCreationRequest.getBookName());
        if (existingBook != null) throw new BookCreationException(GenerateApiResponse.BOOK_ALREADY_EXIST_IN_CATALOG);

        Book book = mapper.map(bookCreationRequest, Book.class);
        book.setBookCategory(BookCategory.valueOf(bookCreationRequest.getBookCategory().toUpperCase()));
        book.setQuantity(bookCreationRequest.getQuantity());

        Book savedBook = bookService.save(book);

        listOfBook.add(savedBook);

        bookCatalog.setListOfBooks(new ArrayList<>(listOfBook));
        BookCatalog updatedCatalog = bookCatalogService.save(bookCatalog);

        librarian.setBookCatalog(updatedCatalog);
        librarianService.save(librarian);


        return GenerateApiResponse.created(GenerateApiResponse.BOOK_SUCCESSFULLY_ADDED_TO_CATALOG);
    }

}

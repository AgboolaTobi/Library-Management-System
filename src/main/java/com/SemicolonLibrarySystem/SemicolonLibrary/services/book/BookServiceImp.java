package com.SemicolonLibrarySystem.SemicolonLibrary.services.book;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Book;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImp implements BookService{

    private final BookRepository bookRepository;
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }
}

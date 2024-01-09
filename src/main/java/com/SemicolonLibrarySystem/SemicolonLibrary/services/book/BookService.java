package com.SemicolonLibrarySystem.SemicolonLibrary.services.book;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Book;

public interface BookService {
    Book save(Book book);

    Book findByBookName(String bookName);

}

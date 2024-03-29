package com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByBookName(String bookName);
}

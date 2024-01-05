package com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.BookCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCatalogRepository extends JpaRepository<BookCatalog,Long> {
}

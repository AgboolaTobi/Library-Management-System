package com.SemicolonLibrarySystem.SemicolonLibrary.services.bookCatalog;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.BookCatalog;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories.BookCatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookCatalogServiceImp  implements BookCatalogService{

    private final BookCatalogRepository bookCatalogRepository;
    @Override
    public BookCatalog save(BookCatalog bookCatalog) {
        return bookCatalogRepository.save(bookCatalog);
    }
}

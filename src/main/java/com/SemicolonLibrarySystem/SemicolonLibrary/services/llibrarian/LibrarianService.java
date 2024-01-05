package com.SemicolonLibrarySystem.SemicolonLibrary.services.llibrarian;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Librarian;

public interface LibrarianService {

    Librarian save(Librarian librarian);

    Librarian findByStaffNumber(String staffNumber);
}

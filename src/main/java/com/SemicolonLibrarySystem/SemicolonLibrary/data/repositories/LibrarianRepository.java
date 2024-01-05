package com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian,Long> {
    Librarian findByStaffNumber(String staffNumber);
}

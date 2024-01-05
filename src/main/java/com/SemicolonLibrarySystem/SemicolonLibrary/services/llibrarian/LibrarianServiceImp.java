package com.SemicolonLibrarySystem.SemicolonLibrary.services.llibrarian;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Librarian;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories.LibrarianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibrarianServiceImp implements LibrarianService {

    private final LibrarianRepository librarianRepository;

    @Override
    public Librarian save(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    @Override
    public Librarian findByStaffNumber(String staffNumber) {
        return librarianRepository.findByStaffNumber(staffNumber);
    }
}

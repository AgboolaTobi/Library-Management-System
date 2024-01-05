package com.SemicolonLibrarySystem.SemicolonLibrary.services.llibrarian;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Librarian;
import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.LibrarianCreationRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.RegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibrarianCreationService {

    private final LibrarianService librarianService;
    private final ModelMapper mapper;

    public ApiResponse registerLibrarian(LibrarianCreationRequest librarianCreationRequest) throws RegistrationException {

        boolean isRegistered = librarianService.findByStaffNumber(librarianCreationRequest.getStaffNumber())!=null;
        
        if (isRegistered) throw new RegistrationException(GenerateApiResponse.INVALID_REGISTRATION_DETAILS);

        Librarian librarian = mapper.map(librarianCreationRequest, Librarian.class);

        librarianService.save(librarian);
        return GenerateApiResponse.created(GenerateApiResponse.REGISTRATION_SUCCESSFULLY_COMPLETED);
    }
}

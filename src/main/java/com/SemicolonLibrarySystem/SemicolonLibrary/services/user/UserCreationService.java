package com.SemicolonLibrarySystem.SemicolonLibrary.services.user;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Desk;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.User;
import com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests.UserRegistrationRequest;
import com.SemicolonLibrarySystem.SemicolonLibrary.exceptions.UserRegistrationException;
import com.SemicolonLibrarySystem.SemicolonLibrary.services.desk.DeskService;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.ApiResponse;
import com.SemicolonLibrarySystem.SemicolonLibrary.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserCreationService {
    private final UserService userService;
    private final DeskService deskService;
    private final ModelMapper mapper;

    public ApiResponse registerUser(UserRegistrationRequest userRegistrationRequest) throws UserRegistrationException {
        boolean isRegistered = userService.findByStudentNumber(userRegistrationRequest.getStudentNumber())!=null;
        if (isRegistered) throw new UserRegistrationException(GenerateApiResponse.INVALID_STUDENT_NUMBER);

        User user = mapper.map(userRegistrationRequest, User.class);
        Desk desk = new Desk();

        Desk savedDesk = deskService.save(desk);

        user.setDesk(savedDesk);
        userService.save(user);

        return GenerateApiResponse.created(GenerateApiResponse.STUDENT_LIBRARY_REGISTRATION_SUCCESSFULLY_COMPLETED);



    }
}

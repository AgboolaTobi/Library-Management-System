package com.SemicolonLibrarySystem.SemicolonLibrary.services.user;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.User;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByStudentNumber(String studentNumber) {
        return userRepository.findByStudentNumber(studentNumber);
    }
}

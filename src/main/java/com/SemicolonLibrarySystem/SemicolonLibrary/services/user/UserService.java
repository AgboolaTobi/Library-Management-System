package com.SemicolonLibrarySystem.SemicolonLibrary.services.user;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.User;


public interface UserService {
    User save(User user);

    User findByStudentNumber(String studentNumber);

}
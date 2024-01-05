package com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

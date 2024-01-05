package com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk,Long> {
}

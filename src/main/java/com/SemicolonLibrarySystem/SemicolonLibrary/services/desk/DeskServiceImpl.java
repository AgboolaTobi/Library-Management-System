package com.SemicolonLibrarySystem.SemicolonLibrary.services.desk;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Desk;
import com.SemicolonLibrarySystem.SemicolonLibrary.data.repositories.DeskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeskServiceImpl implements DeskService{

    private final DeskRepository deskRepository;
    @Override
    public Desk save(Desk desk) {
        return deskRepository.save(desk);
    }

    @Override
    public void removeBook(String bookToRemove) {

    }
}

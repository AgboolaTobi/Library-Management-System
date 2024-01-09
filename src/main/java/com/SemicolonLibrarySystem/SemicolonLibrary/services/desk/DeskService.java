package com.SemicolonLibrarySystem.SemicolonLibrary.services.desk;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.models.Desk;

public interface DeskService {

    Desk save(Desk desk);

    void removeBook(String bookToRemove);
}

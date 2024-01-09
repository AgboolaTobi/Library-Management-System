package com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibrarianRemoveBookRequest {

    private String staffNumber;
    private String bookName;
}

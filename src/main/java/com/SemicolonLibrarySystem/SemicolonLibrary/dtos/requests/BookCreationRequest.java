package com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class BookCreationRequest {

    private String staffNumber;
    private String bookCategory;
    private String bookNumber;
    private String bookName;
    private int quantity;

}

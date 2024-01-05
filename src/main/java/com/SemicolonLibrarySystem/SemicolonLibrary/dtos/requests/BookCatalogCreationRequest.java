package com.SemicolonLibrarySystem.SemicolonLibrary.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookCatalogCreationRequest {
    private String staffNumber;
    private String catalogNumber;
}

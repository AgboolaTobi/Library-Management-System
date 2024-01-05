package com.SemicolonLibrarySystem.SemicolonLibrary.data.models;

import com.SemicolonLibrarySystem.SemicolonLibrary.data.enums.BookCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String bookNumber;
    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

}

package com.SemicolonLibrarySystem.SemicolonLibrary.data.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private char gender;
    private String staffNumber;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private BookCatalog bookCatalog;
}

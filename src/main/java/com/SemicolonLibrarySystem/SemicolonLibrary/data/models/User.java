package com.SemicolonLibrarySystem.SemicolonLibrary.data.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String studentNumber;
    private String gender;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Desk desk;

}

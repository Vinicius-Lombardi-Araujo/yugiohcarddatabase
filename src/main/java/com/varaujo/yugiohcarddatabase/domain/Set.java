package com.varaujo.yugiohcarddatabase.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "SET")
@Data
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank
    private String name;

    @NotNull
    @PastOrPresent
    private LocalDate releaseDate;

    @Column(unique = true)
    @NotBlank
    private String prefix;

    @OneToMany(mappedBy = "set")
    private List<SetCard> cards;
}

package com.varaujo.yugiohcarddatabase.domain;

import jakarta.persistence.*;
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
    private String name;
    private LocalDate releaseDate;
    private String prefix;
    @OneToMany(mappedBy = "set")
    private List<SetCard> cards;
}

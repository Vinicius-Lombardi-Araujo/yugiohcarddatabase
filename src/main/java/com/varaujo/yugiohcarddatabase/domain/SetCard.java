package com.varaujo.yugiohcarddatabase.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.varaujo.yugiohcarddatabase.domain.enums.Rarity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "SET_CARD")
@Data
public class SetCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SET_ID")
    private Set set;

    @ManyToOne
    @JoinColumn(name = "CARD_ID")
    @JsonBackReference
    private Card card;

    @Column(unique = true)
    @NotBlank
    private String setNumber;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Rarity rarity;
}

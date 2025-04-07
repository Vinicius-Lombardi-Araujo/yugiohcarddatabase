package com.varaujo.yugiohcarddatabase.domain;

import com.varaujo.yugiohcarddatabase.domain.enums.Rarity;
import jakarta.persistence.*;
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
    private Card card;
    private String setNumber;
    @Enumerated(EnumType.STRING)
    private Rarity rarity;
}

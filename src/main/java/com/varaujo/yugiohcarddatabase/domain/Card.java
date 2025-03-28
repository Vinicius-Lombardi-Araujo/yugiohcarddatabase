package com.varaujo.yugiohcarddatabase.domain;

import com.varaujo.yugiohcarddatabase.domain.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CARD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String effect;
    @Enumerated(EnumType.STRING)
    private CardType type;  // monster, spell, trap
    @Enumerated(EnumType.STRING)
    private MonsterAttribute attribute;
    private Integer levelRank;
    private MonsterType monsterType; // warrior, beast, machine
    @Enumerated(EnumType.STRING)
    private List<MonsterCategory> monsterCategory; // xyz, synchro effect
    private Integer attack;
    private Integer defense;
    private String pendulumEffect;
    private Integer pendulumScale;
    @Enumerated(EnumType.ORDINAL)
    private List<LinkArrow> linkArrows;
    @Enumerated(EnumType.ORDINAL)
    private SpellTrapType spellTrapType;
    private String image;
}

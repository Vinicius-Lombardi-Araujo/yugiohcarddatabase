package com.varaujo.yugiohcarddatabase.domain;

import com.varaujo.yugiohcarddatabase.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CARD")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String text;
    @Enumerated(EnumType.STRING)
    private CardType type;
    @Enumerated(EnumType.STRING)
    private MonsterAttribute attribute;
    private Integer levelRank;
    private MonsterType monsterType;
    @Enumerated(EnumType.STRING)
    private List<MonsterCategory> monsterCategory;
    private Integer attack;
    private Integer defense;
    private String pendulumEffect;
    private Integer pendulumScale;
    @Enumerated(EnumType.STRING)
    private List<LinkArrow> linkArrows;
    @Enumerated(EnumType.STRING)
    private SpellTrapType spellTrapType;
    private String imageUrl;
}

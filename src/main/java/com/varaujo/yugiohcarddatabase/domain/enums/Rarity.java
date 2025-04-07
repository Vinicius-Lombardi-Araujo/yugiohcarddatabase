package com.varaujo.yugiohcarddatabase.domain.enums;

public enum Rarity {
    C("Common"),
    R("Rare"),
    SR("Super Rare"),
    UR("Ultra Rare"),
    UL("Ultimate Rare"),
    SE("Secret Rare"),
    GH("Ghost Rare"),
    CR("Collector's Rare"),
    STAR("Starlight Rare"),
    PS("Platinum Secret Rare"),
    QCSE("Quarter Century Secret Rare");

    private final String name;

    Rarity(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }


}

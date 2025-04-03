package com.varaujo.yugiohcarddatabase.service;

import com.varaujo.yugiohcarddatabase.domain.Card;
import com.varaujo.yugiohcarddatabase.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(Long id) throws Exception {
        return cardRepository.findById(id)
                .orElseThrow(Exception::new);
    }

    public Card findByName(String name) throws Exception {
        return cardRepository.findByName(name)
                .orElseThrow(Exception::new);
    }

    public Card update(Card card) throws Exception {
        Card existingCard = cardRepository.findById(card.getId())
                .orElseThrow(Exception::new);

        if(!card.getName().isEmpty()) existingCard.setName(card.getName());
        if(!card.getEffect().isEmpty()) existingCard.setEffect(card.getEffect());
        if(card.getType() != null) existingCard.setType(card.getType());
        if(card.getAttribute() != null) existingCard.setAttribute(card.getAttribute());
        if(card.getLevelRank() != null) existingCard.setLevelRank(card.getLevelRank());
        if(card.getMonsterType() != null) existingCard.setMonsterType(card.getMonsterType());
        if(card.getMonsterCategory() != null) existingCard.setMonsterCategory(card.getMonsterCategory());
        if(card.getAttack() != null) existingCard.setAttack(card.getAttack());
        if(card.getDefense() != null) existingCard.setDefense(card.getDefense());
        if(!card.getPendulumEffect().isEmpty()) existingCard.setPendulumEffect(card.getPendulumEffect());
        if(card.getPendulumScale() != null) existingCard.setPendulumScale(card.getPendulumScale());
        if(!card.getLinkArrows().isEmpty()) existingCard.setLinkArrows(card.getLinkArrows());
        if(card.getSpellTrapType() != null) existingCard.setSpellTrapType(card.getSpellTrapType());
        if(!card.getImageUrl().isEmpty()) existingCard.setName(card.getImageUrl());

        return cardRepository.save(existingCard);
    }

    public void delete(Long id) throws Exception {
        Card card = cardRepository.findById(id)
                .orElseThrow(Exception::new);
        cardRepository.delete(card);
    }

}

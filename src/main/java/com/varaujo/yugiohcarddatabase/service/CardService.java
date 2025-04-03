package com.varaujo.yugiohcarddatabase.service;

import com.varaujo.yugiohcarddatabase.domain.Card;
import com.varaujo.yugiohcarddatabase.repository.CardRepository;
import io.micrometer.common.util.StringUtils;
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

    public Card update(Long id, Card card) throws Exception {
        Card existingCard = cardRepository.findById(id)
                .orElseThrow(Exception::new);
        mergeCard(card, existingCard);
        return cardRepository.save(existingCard);
    }

    public void delete(Long id) throws Exception {
        Card card = cardRepository.findById(id)
                .orElseThrow(Exception::new);
        cardRepository.delete(card);
    }
    
    private void mergeCard(Card updatedCard, Card existingCard) {
        if(StringUtils.isBlank(updatedCard.getName())) existingCard.setName(updatedCard.getName());
        if(StringUtils.isBlank(updatedCard.getEffect())) existingCard.setEffect(updatedCard.getEffect());
        if(updatedCard.getType() != null) existingCard.setType(updatedCard.getType());
        if(updatedCard.getAttribute() != null) existingCard.setAttribute(updatedCard.getAttribute());
        if(updatedCard.getLevelRank() != null) existingCard.setLevelRank(updatedCard.getLevelRank());
        if(updatedCard.getMonsterType() != null) existingCard.setMonsterType(updatedCard.getMonsterType());
        if(updatedCard.getMonsterCategory() != null) existingCard.setMonsterCategory(updatedCard.getMonsterCategory());
        if(updatedCard.getAttack() != null) existingCard.setAttack(updatedCard.getAttack());
        if(updatedCard.getDefense() != null) existingCard.setDefense(updatedCard.getDefense());
        if(StringUtils.isBlank(updatedCard.getPendulumEffect())) existingCard.setPendulumEffect(updatedCard.getPendulumEffect());
        if(updatedCard.getPendulumScale() != null) existingCard.setPendulumScale(updatedCard.getPendulumScale());
        if(updatedCard.getLinkArrows().isEmpty()) existingCard.setLinkArrows(updatedCard.getLinkArrows());
        if(updatedCard.getSpellTrapType() != null) existingCard.setSpellTrapType(updatedCard.getSpellTrapType());
        if(StringUtils.isBlank(updatedCard.getImageUrl())) existingCard.setImageUrl(updatedCard.getImageUrl());
    }

}

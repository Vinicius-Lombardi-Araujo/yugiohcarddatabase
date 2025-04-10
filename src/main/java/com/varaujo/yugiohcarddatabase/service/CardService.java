package com.varaujo.yugiohcarddatabase.service;

import com.varaujo.yugiohcarddatabase.domain.Card;
import com.varaujo.yugiohcarddatabase.domain.enums.CardType;
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
        card.setId(id);
        return cardRepository.save(card);
    }

    public void delete(Long id) throws Exception {
        Card card = cardRepository.findById(id)
                .orElseThrow(Exception::new);
        cardRepository.delete(card);
    }
}

package com.varaujo.yugiohcarddatabase.service;

import com.varaujo.yugiohcarddatabase.domain.Card;
import com.varaujo.yugiohcarddatabase.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Card findByName(String name) throws Exception {
        return cardRepository.findByName(name).orElseThrow(Exception::new);
    }

}

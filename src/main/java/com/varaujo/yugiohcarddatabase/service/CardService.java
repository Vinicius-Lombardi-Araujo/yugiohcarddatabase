package com.varaujo.yugiohcarddatabase.service;

import com.varaujo.yugiohcarddatabase.domain.Card;
import com.varaujo.yugiohcarddatabase.domain.enums.CardType;
import com.varaujo.yugiohcarddatabase.repository.CardRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
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

package com.varaujo.yugiohcarddatabase.controller;

import com.varaujo.yugiohcarddatabase.domain.Card;
import com.varaujo.yugiohcarddatabase.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    @PostMapping
    public ResponseEntity<Card> insert(@RequestBody Card card) {
        return ResponseEntity.ok().body(cardService.save(card));
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAll() {
        return ResponseEntity.ok(cardService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable("id") Long id, @RequestBody Card card) throws Exception {
        return ResponseEntity.ok().body(cardService.update(id, card));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> delete(@PathVariable("id") Long id) throws Exception {
        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}

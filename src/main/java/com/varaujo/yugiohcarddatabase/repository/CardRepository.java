package com.varaujo.yugiohcarddatabase.repository;

import com.varaujo.yugiohcarddatabase.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByName(String name);
}

package com.varaujo.yugiohcarddatabase;

import com.varaujo.yugiohcarddatabase.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}

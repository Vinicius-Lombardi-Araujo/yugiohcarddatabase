package com.varaujo.yugiohcarddatabase.repository;

import com.varaujo.yugiohcarddatabase.domain.SetCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetCardRepository extends JpaRepository<SetCard, Long> {
}

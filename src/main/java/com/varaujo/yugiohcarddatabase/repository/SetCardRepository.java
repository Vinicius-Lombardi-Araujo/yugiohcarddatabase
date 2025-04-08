package com.varaujo.yugiohcarddatabase.repository;

import com.varaujo.yugiohcarddatabase.domain.SetCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetCardRepository extends JpaRepository<SetCard, Long> {
}

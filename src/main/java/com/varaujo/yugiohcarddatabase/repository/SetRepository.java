package com.varaujo.yugiohcarddatabase.repository;

import com.varaujo.yugiohcarddatabase.domain.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<Set, Long> {
}

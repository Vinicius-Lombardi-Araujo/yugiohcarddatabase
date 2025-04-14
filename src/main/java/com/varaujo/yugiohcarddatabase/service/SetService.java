package com.varaujo.yugiohcarddatabase.service;

import com.varaujo.yugiohcarddatabase.domain.Card;
import com.varaujo.yugiohcarddatabase.domain.Set;
import com.varaujo.yugiohcarddatabase.repository.SetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SetService {

    private final SetRepository setRepository;

    public Set save(Set set) {
        return setRepository.save(set);
    }

    public List<Set> findAll() {
        return setRepository.findAll();
    }

    public Set update(Long id, Set card) throws Exception {
        Set existingSet = setRepository.findById(id)
                .orElseThrow(Exception::new);
        card.setId(id);
        return setRepository.save(card);
    }

    public void delete(Long id) throws Exception {
        Set card = setRepository.findById(id)
                .orElseThrow(Exception::new);
        setRepository.delete(card);
    }
}

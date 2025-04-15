package com.varaujo.yugiohcarddatabase.controller;

import com.varaujo.yugiohcarddatabase.domain.Set;
import com.varaujo.yugiohcarddatabase.service.SetService;
import com.varaujo.yugiohcarddatabase.domain.Card;
import com.varaujo.yugiohcarddatabase.service.CardService;
import com.varaujo.yugiohcarddatabase.service.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sets")
@RequiredArgsConstructor
public class SetController {

    private final SetService setService;
    
    @PostMapping
    public ResponseEntity<Set> insert(@RequestBody Set set) {
        return ResponseEntity.ok().body(setService.save(set));
    }

    @GetMapping
    public ResponseEntity<List<Set>> getAll() {
        return ResponseEntity.ok(setService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Set> update(@PathVariable("id") Long id, @RequestBody Set set) throws Exception {
        return ResponseEntity.ok().body(setService.update(id, set));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Set> delete(@PathVariable("id") Long id) throws Exception {
        setService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

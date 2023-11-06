package com.example.progettino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.progettino.model.Prodotto;
import com.example.progettino.service.ProdottoService;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {
	
	@Autowired
    private ProdottoService prodottoService;

    // GET: Ottenere tutti i prodotti
    @GetMapping("/all")
    public ResponseEntity<List<Prodotto>> getAllProdotti() {
        return ResponseEntity.ok(prodottoService.findAll());
    }

    // GET: Ottenere un prodotto specifico
    @GetMapping
    public ResponseEntity<Prodotto> getProdottoById(@RequestParam Long id) {
        return prodottoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Creare un nuovo prodotto
    @PostMapping
    public ResponseEntity<Prodotto> createProdotto(@RequestBody Prodotto prodotto) {
    	return ResponseEntity.ok(prodottoService.save(prodotto));
    }

    // PUT: Modificare un prodotto esistente
    @PutMapping
    public ResponseEntity<Prodotto> updateProdotto(@RequestParam Long id, @RequestBody Prodotto prodotto) {
        if (!prodottoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        prodotto.setId(id); // Assicurati che l'ID nel corpo corrisponda all'ID nel path
        return ResponseEntity.ok(prodottoService.save(prodotto));
    }

    // DELETE: Eliminare un prodotto
    @DeleteMapping
    public ResponseEntity<Void> deleteProdotto(@RequestParam Long id) {
        prodottoService.delete(id);
        return ResponseEntity.ok().build();
    }
}

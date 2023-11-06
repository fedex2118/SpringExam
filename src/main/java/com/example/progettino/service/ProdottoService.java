package com.example.progettino.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettino.model.Ordine;
import com.example.progettino.model.Prodotto;
import com.example.progettino.repository.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
    private ProdottoRepository prodottoRepository;

    // Salvare un prodotto
    public Prodotto save(Prodotto prodotto) {
    	Prodotto s = new Prodotto();
    	
    	s.setId(prodotto.getId());
    	s.setNome(prodotto.getNome());
    	s.setPrezzo(prodotto.getPrezzo());
    	s.setQuantita(prodotto.getQuantita());
    	
    	// TODO si possono aggiungere ulteriori controlli
    	
    	Set<Ordine> ordini = prodotto.getOrdini();
    	
    	if(ordini != null)
    		s.setOrdini(prodotto.getOrdini());
    	
    	
        return prodottoRepository.save(s);
    }

    // Trovare tutti i servizi
    public List<Prodotto> findAll() {
        return prodottoRepository.findAll();
    }

    // Trovare un servizio per ID
    public Optional<Prodotto> findById(Long id) {
        return prodottoRepository.findById(id);
    }

    // Eliminare un servizio
    public void delete(Long id) {
        prodottoRepository.deleteById(id);
    }
    
 // TODO da implementare l'update!!!!!
}

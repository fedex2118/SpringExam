package com.example.progettino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettino.model.Prodotto;
import com.example.progettino.repository.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
    private ProdottoRepository prodottoRepository;

    // Salvare un prodotto // TODO riparti da qui
    public Prodotto save(Prodotto prodotto) {
    	Prodotto s = new Prodotto();
    	
//    	System.out.println(servizio.getTempoEsecuzione());
    	
//    	s.setId(servizio.getId());
//    	s.setTempoEsecuzione(time);
//    	s.setCosto(servizio.getCosto());
//    	s.setTipoServizio(tipoServizio);
    	
    	
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
}

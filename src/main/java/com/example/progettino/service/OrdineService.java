package com.example.progettino.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettino.model.Cliente;
import com.example.progettino.model.Ordine;
import com.example.progettino.model.Prodotto;
import com.example.progettino.repository.ClienteRepository;
import com.example.progettino.repository.OrdineRepository;
import com.example.progettino.repository.ProdottoRepository;

@Service
public class OrdineService {

	@Autowired
    private OrdineRepository ordineRepository;
	
	@Autowired
    private ClienteRepository clienteRepository;
	
	@Autowired
    private ProdottoRepository prodottoRepository;

    // Salvare un ordine
    public Ordine save(Ordine ordine, Long clienteId) {
    	Set<Prodotto> prodotti = ordine.getProdotti();
    	Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
    	
    	if(cliente == null || prodotti.isEmpty()) {
    		System.err.println("Cliente non esiste oppure non hai aggiunto prodotti!");
    		return null;
    	}
    	
    	double costoTotale = 0.0;
    	
    	for(Prodotto s: prodotti) {
    		// L'id va sempre messo nel body per funzionare altrimenti abbiamo errore!
    		Prodotto serv = prodottoRepository.findById(s.getId()).orElse(null);
    		
    		if(serv == null) {
    			System.err.println("Errore: uno dei servizi nel body ha un id che non esiste...");
    			System.err.println("...oppure non c'era un id nel body della richiesta!");
    			return null;
    		}
    		
    		s.setPrezzo(serv.getPrezzo());
    		s.setNome(serv.getNome());
    		s.setQuantita(serv.getQuantita());
    		s.setOrdini(serv.getOrdini()); // TODO check
    	}
    	
    	for(Prodotto s: prodotti) {
    		costoTotale += s.getPrezzo();
    	}
    	
    	// TODO si potrebbero gestire dataConsegna e dataRitiro...
    	
    	Ordine o = new Ordine();
    	o.setId(ordine.getId());
    	o.setDataConsegna(ordine.getDataConsegna());
    	o.setDataRitiro(ordine.getDataRitiro());
    	o.setCliente(cliente);
    	o.setProdotti(prodotti);
    	o.setCostoTotale(costoTotale);
    	
    	// Debug
    	System.out.println(prodotti);
    	System.out.println(costoTotale);
    	
        return ordineRepository.save(o);
    }
    
    public Ordine save(Ordine ordine) {
    	return ordineRepository.save(ordine);
    }

    // Trovare tutti gli ordini
    public List<Ordine> findAll() {
        return ordineRepository.findAll();
    }

    // Trovare un ordine per ID
    public Optional<Ordine> findById(Long id) {
        return ordineRepository.findById(id);
    }
    
    // TODO fare update ordine

    // Eliminare un ordine
    public void delete(Long id) {
        ordineRepository.deleteById(id);
    }

    // Recuperare il cliente associato a un ordine
    public Optional<Cliente> findClienteByOrdineId(Long id) {
        Optional<Ordine> ordine = ordineRepository.findById(id);
        return ordine.map(Ordine::getCliente);
    }
    
    public Ordine update(Ordine ordine) {
    	// TODO da fare
    	return ordine;
    }
}

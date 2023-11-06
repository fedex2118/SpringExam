package com.example.progettino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettino.model.Cliente;
import com.example.progettino.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
    
    public Cliente update(Long id, Cliente clienteDetails) {
    	Cliente cliente = findById(id).orElse(null);
    	
    	if(cliente == null)
    		return null; // lo gestisco nel controller
    	
    	String nome = clienteDetails.getNome();
    	String cognome = clienteDetails.getCognome();
    	String numero_telefono = clienteDetails.getNumeroTelefono();
    	String email = clienteDetails.getEmail();
    	
    	if(nome != null)
    		cliente.setNome(nome);
    	if(cognome != null)
    		cliente.setCognome(cognome);
    	if(numero_telefono != null)
    		cliente.setNumeroTelefono(numero_telefono);
    	if(email != null)
    		cliente.setEmail(email);
    	
    	return save(cliente);
    }
}

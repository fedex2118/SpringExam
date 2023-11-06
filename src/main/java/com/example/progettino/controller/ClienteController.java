package com.example.progettino.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.progettino.model.Cliente;
import com.example.progettino.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.save(cliente);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clienti = clienteService.findAll();
        return new ResponseEntity<>(clienti, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Cliente> findById(@RequestParam Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            return new ResponseEntity<>(clienteOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        try {
            clienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@RequestParam Long id, @RequestBody Cliente clienteDetails) {
        Cliente updatedCliente = clienteService.update(id, clienteDetails);

        // check da fare
        
        if(updatedCliente != null) {
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}

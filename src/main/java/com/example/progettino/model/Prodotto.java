package com.example.progettino.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotto")
public class Prodotto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "nome")
	private String nome;
	
	@Column(name = "prezzo")
	private Float prezzo;
	
	@Column(name = "quantita")
	private Integer quantita;
	
    @ManyToMany(mappedBy = "prodotti")
    private Set<Ordine> ordini;
	
	public Prodotto() {
		
	}
	
	public Prodotto(Long id, String nome, Float prezzo, Integer quantita) {
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Set<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(Set<Ordine> ordini) {
		this.ordini = ordini;
	}
	
}

package com.example.progettino.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @JsonProperty("data_consegna")
    @Column(name = "data_consegna")
	private LocalDate dataConsegna;
    @JsonProperty("data_ritiro")
    @Column(name = "data_ritiro")
	private LocalDate dataRitiro;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
    
	
	// creiamo una tabella ponte tra ordini e servizi associati!
    @ManyToMany
    @JoinTable(
            name = "ordine_prodotto",
            joinColumns = @JoinColumn(name = "ordine_id"),
            inverseJoinColumns = @JoinColumn(name = "prodotto_id")
        )
	private Set<Prodotto> prodotti;
	
    private double costoTotale;
    
    public Ordine() {
    	
    }

	public Ordine(Long id, LocalDate dataConsegna, LocalDate dataRitiro, com.example.progettino.model.Cliente cliente,
			Set<Prodotto> prodotti, double costoTotale) {
		super();
		this.id = id;
		this.dataConsegna = dataConsegna;
		this.dataRitiro = dataRitiro;
		this.cliente = cliente;
		this.prodotti = prodotti;
		this.costoTotale = costoTotale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(LocalDate dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public LocalDate getDataRitiro() {
		return dataRitiro;
	}

	public void setDataRitiro(LocalDate dataRitiro) {
		this.dataRitiro = dataRitiro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(Set<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public double getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}
    
}

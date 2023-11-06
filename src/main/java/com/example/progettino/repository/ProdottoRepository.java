package com.example.progettino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.progettino.model.Prodotto;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{

}

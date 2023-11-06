package com.example.progettino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.progettino.model.Ordine;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

}

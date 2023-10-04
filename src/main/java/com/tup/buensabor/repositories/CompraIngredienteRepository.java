package com.example.demo.repositories;


import com.tup.buensabor.entities.CompraIngredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraIngredienteRepository extends JpaRepository<CompraIngredientes, Long> {
}

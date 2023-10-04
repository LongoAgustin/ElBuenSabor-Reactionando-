package com.example.demo.repositories;


import com.tup.buensabor.entities.DetalleCompraIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraIngredienteRepository extends JpaRepository<DetalleCompraIngrediente, Long> {
}

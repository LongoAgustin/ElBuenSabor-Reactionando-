package com.example.demo.repositories;


import com.tup.buensabor.entities.DetalleNotaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleNotaCreditoRepository extends JpaRepository<DetalleNotaCredito, Long> {
}

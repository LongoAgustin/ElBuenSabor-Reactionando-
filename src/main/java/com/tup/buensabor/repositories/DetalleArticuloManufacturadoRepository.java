package com.example.demo.repositories;


import com.tup.buensabor.entities.DetalleArticuloManufacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleArticuloManufacturadoRepository extends JpaRepository<DetalleArticuloManufacturado, Long> {
}

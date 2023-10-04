package com.example.demo.repositories;


import com.tup.buensabor.entities.RubroArticuloProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroArticuloProductoRepository extends JpaRepository<RubroArticuloProducto, Long> {
}

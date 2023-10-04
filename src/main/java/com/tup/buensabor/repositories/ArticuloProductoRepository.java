package com.example.demo.repositories;


import com.tup.buensabor.entities.ArticuloProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloProductoRepository extends JpaRepository<ArticuloProducto, Long>{
}

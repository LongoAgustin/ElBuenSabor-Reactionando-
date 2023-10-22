package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{

    @Query(value = "SELECT p FROM Producto p WHERE TYPE(p) IN (ProductoInsumo, ProductoCocina)")
    List<Producto> buscarProductos();

}

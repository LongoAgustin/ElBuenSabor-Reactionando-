package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{
    @Query(value = "SELECT p FROM Producto p WHERE p.denominacion = :denom_ingresada")
    List<Producto> buscarProducto(@Param("denom_ingresada") String denominacion);

}

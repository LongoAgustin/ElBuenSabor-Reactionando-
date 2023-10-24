package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.RubroProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroProductoRepository extends BaseRepository<RubroProducto, Long> {

    @Query(value = "SELECT * FROM rubro_producto WHERE rubro_producto.denominacion = :rubro_ingresado", nativeQuery = true)
    List<RubroProducto> verificarRubroProducto(@Param("rubro_ingresado") String denominacion);
}

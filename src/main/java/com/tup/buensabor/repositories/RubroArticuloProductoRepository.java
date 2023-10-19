package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.entities.RubroArticuloProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloProductoRepository extends BaseRepository<RubroArticuloProducto, Long> {
    @Query(value = "SELECT * FROM rubro_producto WHERE rubro_producto.denominacion = :rubro_ingresado", nativeQuery = true)
    List<RubroArticuloProducto> verificarRubroProducto(@Param("rubro_ingresado") String denominacion);
}

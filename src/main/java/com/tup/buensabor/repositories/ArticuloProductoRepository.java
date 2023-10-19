package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.entities.ArticuloProducto;
import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.entities.RubroArticuloProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloProductoRepository extends BaseRepository<ArticuloProducto, Long>{

    @Query( value = "SELECT * FROM articulo_producto WHERE articulo_producto.denominacion = :denominacion", nativeQuery = true)
    List<ArticuloProducto> verificarProducto(@Param("denominacion") String denominacion);

}
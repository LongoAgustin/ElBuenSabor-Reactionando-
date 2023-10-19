package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticuloIngredienteRepository extends BaseRepository<ArticuloIngrediente, Long> {

    @Query( value = "SELECT * FROM articulo_ingrediente WHERE articulo_ingrediente.denominacion = :denominacion", nativeQuery = true)
    List<ArticuloIngrediente> verificarIngrediente(@Param("denominacion") String denominacion);


    //muestra los q tienen fechaBaja = null
    @Query( value = "SELECT * FROM articulo_ingrediente WHERE articulo_ingrediente.fecha_baja IS null", nativeQuery = true)
    List<ArticuloIngrediente> verificarFechaBajaIngrediente();


    @Query( value = "SELECT * FROM articulo_ingrediente WHERE (stock_actual <= stock_minimo) OR (stock_actual <= (stock_minimo + 0.2*stock_minimo)) ", nativeQuery = true)
    List<ArticuloIngrediente> stockBajo();


}

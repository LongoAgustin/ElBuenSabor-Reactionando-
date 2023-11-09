package com.tup.buensabor.repositories.IngredienteRepository;

import com.tup.buensabor.entities.Ingrediente.Ingrediente;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends BaseRepository<Ingrediente, Long> {

    @Query(value = "SELECT * FROM ingrediente WHERE ingrediente.denominacion = :denominacion", nativeQuery = true)
    List<Ingrediente> verificarIngrediente(@Param("denominacion") String denominacion);

    @Query( value = "SELECT * FROM ingrediente WHERE (stock_actual <= stock_minimo) OR (stock_actual <= (stock_minimo + 0.2*stock_minimo)) ", nativeQuery = true)
    List<Ingrediente> stockBajo();
}

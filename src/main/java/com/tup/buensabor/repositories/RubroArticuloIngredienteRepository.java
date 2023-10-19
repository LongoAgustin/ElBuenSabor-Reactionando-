package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RubroArticuloIngredienteRepository extends BaseRepository<RubroArticuloIngrediente, Long> {

    @Query(value = "SELECT * FROM rubro_ingrediente WHERE rubro_ingrediente.denominacion = :rubro_ingresado", nativeQuery = true)
    List<RubroArticuloIngrediente> verificarRubroIngrediente(@Param("rubro_ingresado") String denominacion);


}

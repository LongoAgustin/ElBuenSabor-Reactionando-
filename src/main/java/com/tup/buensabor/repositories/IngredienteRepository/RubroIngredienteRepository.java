package com.tup.buensabor.repositories.IngredienteRepository;

import com.tup.buensabor.entities.Ingrediente.RubroIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroIngredienteRepository extends BaseRepository<RubroIngrediente, Long> {

    @Query(value = "SELECT * FROM rubro_ingrediente WHERE rubro_ingrediente.denominacion = :rubro_ingresado", nativeQuery = true)
    List<RubroIngrediente> verificarRubroIngrediente(@Param("rubro_ingresado") String denominacion);

}

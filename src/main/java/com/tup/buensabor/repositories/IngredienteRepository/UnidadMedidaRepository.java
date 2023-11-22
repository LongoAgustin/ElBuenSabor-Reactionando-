package com.tup.buensabor.repositories.IngredienteRepository;

import com.tup.buensabor.entities.Ingrediente.RubroIngrediente;
import com.tup.buensabor.entities.Ingrediente.UnidadMedida;
import com.tup.buensabor.repositories.BaseRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida, Long> {

    @Query(value = "SELECT * FROM unidad_medida WHERE unidad_medida.denominacion = :unidad_ingresada", nativeQuery = true)
    List<UnidadMedida> findByDenominaion(@Param("unidad_ingresada") String denominacion);

}

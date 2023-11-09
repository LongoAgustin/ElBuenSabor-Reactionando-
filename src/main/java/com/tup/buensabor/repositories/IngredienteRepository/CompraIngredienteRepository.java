package com.tup.buensabor.repositories.IngredienteRepository;

import com.tup.buensabor.entities.Ingrediente.CompraIngredientes;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraIngredienteRepository extends BaseRepository<CompraIngredientes, Long> {
}

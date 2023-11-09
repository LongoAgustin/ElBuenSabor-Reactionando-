package com.tup.buensabor.repositories.IngredienteRepository;

import com.tup.buensabor.entities.Ingrediente.DetalleCompraIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraIngredienteRepository extends BaseRepository<DetalleCompraIngrediente, Long> {
}

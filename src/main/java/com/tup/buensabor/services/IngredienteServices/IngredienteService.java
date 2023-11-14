package com.tup.buensabor.services.IngredienteServices;

import com.tup.buensabor.entities.Ingrediente.Ingrediente;
import com.tup.buensabor.services.BaseService;

import java.util.List;

public interface IngredienteService extends BaseService<Ingrediente, Long> {

    public Ingrediente newIngrediente(Ingrediente ingrediente) throws Exception;

    public Ingrediente updateIngrediente (Long id, Ingrediente nuevosDatos) throws Exception;

    public List<Ingrediente> stockBajo() throws Exception;
}

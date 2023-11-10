package com.tup.buensabor.services.IngredienteServices;

import com.tup.buensabor.entities.Ingrediente.RubroIngrediente;
import com.tup.buensabor.services.BaseService;

public interface RubroIngredienteService extends BaseService<RubroIngrediente, Long> {

    public RubroIngrediente newRubroIngrediente (RubroIngrediente rubroIngrediente) throws Exception;

    public RubroIngrediente updateRubroIngrediente (Long id, RubroIngrediente nuevosDatos) throws Exception;
}

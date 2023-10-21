package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroIngrediente;

public interface RubroIngredienteService extends BaseService<RubroIngrediente, Long>{

    public RubroIngrediente newRubroIngrediente (RubroIngrediente rubroIngrediente) throws Exception;

    public RubroIngrediente updateRubroIngrediente (Long id, RubroIngrediente nuevosDatos) throws Exception;
}

package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.entities.RubroArticuloProducto;
import org.springframework.http.ResponseEntity;

public interface RubroArticuloIngredienteService extends BaseService<RubroArticuloIngrediente, Long>{

    public RubroArticuloIngrediente newRubroIngrediente(RubroArticuloIngrediente rubroArticuloIngrediente) throws Exception;

    RubroArticuloIngrediente updateRubroIngrediente(Long id, RubroArticuloIngrediente nuevosDatos) throws Exception;
}

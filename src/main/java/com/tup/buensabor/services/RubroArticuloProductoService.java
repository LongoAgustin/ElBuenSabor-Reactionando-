package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.entities.RubroArticuloProducto;

public interface RubroArticuloProductoService extends BaseService<RubroArticuloProducto, Long>{
    public RubroArticuloProducto newRubroProducto(RubroArticuloProducto rubroArticuloProducto) throws Exception;

}

package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroIngrediente;
import com.tup.buensabor.entities.RubroProducto;

public interface RubroProductoService extends BaseService<RubroProducto, Long>{

    public RubroProducto newRubroProducto(RubroProducto rubroArticuloProducto) throws Exception;

    public RubroProducto updateRubroProducto (Long id, RubroProducto nuevosDatos) throws Exception;

}

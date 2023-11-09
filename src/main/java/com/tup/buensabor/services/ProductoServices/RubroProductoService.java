package com.tup.buensabor.services.ProductoServices;

import com.tup.buensabor.entities.Producto.RubroProducto;
import com.tup.buensabor.services.BaseService;

public interface RubroProductoService extends BaseService<RubroProducto, Long> {

    public RubroProducto newRubroProducto(RubroProducto rubroArticuloProducto) throws Exception;

    public RubroProducto updateRubroProducto (Long id, RubroProducto nuevosDatos) throws Exception;

}

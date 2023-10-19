package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.entities.ArticuloProducto;
import com.tup.buensabor.entities.RubroArticuloIngrediente;

public interface ArticuloProductoService extends BaseService<ArticuloProducto, Long>{

    public ArticuloProducto newProducto(ArticuloProducto articuloProducto) throws Exception;

}

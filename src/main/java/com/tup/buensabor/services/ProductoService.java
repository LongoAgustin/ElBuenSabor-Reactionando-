package com.tup.buensabor.services;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.request.ProductRequest;

import java.util.List;

public interface ProductoService extends BaseService<Producto, Long>{

    List<Producto> obtenerProductos() throws Exception;

    Producto agregarProducto(ProductRequest productRequest) throws Exception;

}

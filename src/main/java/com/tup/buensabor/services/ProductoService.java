package com.tup.buensabor.services;

import com.tup.buensabor.entities.Producto;

import java.util.List;

public interface ProductoService extends BaseService<Producto, Long>{

    List<Producto> obtenerProductos() throws Exception;

}

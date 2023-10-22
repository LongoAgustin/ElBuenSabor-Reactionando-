package com.tup.buensabor.services;

import com.tup.buensabor.DTOs.DTOProducto;
import com.tup.buensabor.entities.Producto;

import java.util.List;

public interface ProductoService extends BaseService<Producto, Long>{

    DTOProducto obtenerProductos() throws Exception;

}

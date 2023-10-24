package com.tup.buensabor.services;

import com.tup.buensabor.DTO.DTOProductoCocina;
import com.tup.buensabor.DTO.DTOProductoPagPrincipal;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.request.ProductoRequest;

import java.util.List;

import java.util.List;

public interface ProductoService extends BaseService<Producto, Long>{

    List<Producto> obtenerProductos() throws Exception;

    Producto agregarProducto(ProductoRequest productoRequest) throws Exception;

    Producto actualizarProducto(ProductoRequest productoRequest, Long id) throws Exception;

    public List<Producto> searchDenominacion(String filtro) throws Exception;

    public List<Producto> searchCategoria(String cate) throws Exception;

    public DTOProductoCocina getReceta(Long id) throws Exception;

    public List<DTOProductoPagPrincipal> getProdPagPrincipal() throws Exception;

}

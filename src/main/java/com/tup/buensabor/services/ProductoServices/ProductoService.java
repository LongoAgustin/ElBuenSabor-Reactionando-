package com.tup.buensabor.services.ProductoServices;

import com.tup.buensabor.DTO.DTOProductoCocina;
import com.tup.buensabor.DTO.DTOProductoPagPrincipal;

import com.tup.buensabor.request.DTOProductoRequest;
import com.tup.buensabor.entities.Producto.Producto;
import com.tup.buensabor.services.BaseService;

import java.util.List;


public interface ProductoService extends BaseService<Producto, Long> {

    List<Producto> obtenerProductos() throws Exception;

    Producto agregarProducto(DTOProductoRequest DTOProductoRequest) throws Exception;

    Producto actualizarProducto(DTOProductoRequest DTOProductoRequest, Long id) throws Exception;

    public List<Producto> searchDenominacion(String filtro) throws Exception;

    public List<Producto> searchCategoria(String cate) throws Exception;

    public DTOProductoCocina getReceta(Long id) throws Exception;

    public List<DTOProductoPagPrincipal> getProdPagPrincipal() throws Exception;

}

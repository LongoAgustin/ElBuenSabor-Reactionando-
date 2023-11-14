package com.tup.buensabor.services.ProductoServices;

import com.tup.buensabor.DTO.DTOProductoCocina;
import com.tup.buensabor.DTO.DTOProductoPagPrincipal;

import com.tup.buensabor.DTO.DTOProducto;
import com.tup.buensabor.entities.Producto.Producto;
import com.tup.buensabor.services.BaseService;

import java.util.List;


public interface ProductoService extends BaseService<Producto, Long> {

    List<DTOProducto> obtenerProductos() throws Exception;

    Producto agregarProducto(DTOProducto DTOProducto) throws Exception;

    Producto actualizarProducto(DTOProducto DTOProducto, Long id) throws Exception;

    public String bajaProducto(Long id) throws Exception;

    //HISTORIA 9

    public List<Producto> searchDenominacion(String filtro) throws Exception;

    public List<Producto> searchCategoria(String cate) throws Exception;

    public DTOProductoCocina getReceta(Long id) throws Exception;

    //HISTORIA 10

    public List<DTOProductoPagPrincipal> getProdPagPrincipal() throws Exception;


}

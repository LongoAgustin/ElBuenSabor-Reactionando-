package com.tup.buensabor.services;

import com.tup.buensabor.DTO.DTOProductoCocina;
import com.tup.buensabor.entities.Producto;

import java.util.List;

public interface ProductoService extends BaseService<Producto, Long>{

    public List<Producto> searchDenominacion(String filtro) throws Exception;

    public List<Producto> searchCategoria(String cate) throws Exception;

    public DTOProductoCocina getReceta(Long id) throws Exception;

}

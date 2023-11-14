package com.tup.buensabor.factory;

import com.tup.buensabor.DTO.DTOProducto;
import com.tup.buensabor.entities.Producto.Producto;
import com.tup.buensabor.entities.Producto.ProductoCocina;
import com.tup.buensabor.entities.Producto.ProductoInsumo;

public class ProductoFactory {

    public Producto crearProducto(DTOProducto DTOProducto) throws Exception{
        if(DTOProducto.getTipoProducto().equals("Cocina")){
            return new ProductoCocina();
        } else if (DTOProducto.getTipoProducto().equals("Insumo")) {
            return new ProductoInsumo();
        } else {
            throw new Exception("Pusiste cualquier cosa nada que ver jajaja");
        }
    }

}

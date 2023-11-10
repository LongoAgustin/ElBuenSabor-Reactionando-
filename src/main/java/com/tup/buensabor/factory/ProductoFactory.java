package com.tup.buensabor.factory;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.entities.ProductoInsumo;
import com.tup.buensabor.request.DTOProductoRequest;

public class ProductoFactory {

    public Producto crearProducto(DTOProductoRequest DTOProductoRequest) throws Exception{
        if(DTOProductoRequest.getTipoProducto().equals("Cocina")){
            return new ProductoCocina();
        } else if (DTOProductoRequest.getTipoProducto().equals("Insumo")) {
            return new ProductoInsumo();
        } else {
            throw new Exception("Pusiste cualquier cosa nada que ver jajaja");
        }
    }

}

package com.tup.buensabor.factory;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.entities.ProductoInsumo;
import com.tup.buensabor.request.ProductoRequest;

public class ProductoFactory {

    public Producto crearProducto(ProductoRequest productoRequest) throws Exception{
        if(productoRequest.getTipoProducto().equals("Cocina")){
            return new ProductoCocina();
        } else if (productoRequest.getTipoProducto().equals("Insumo")) {
            return new ProductoInsumo();
        } else {
            throw new Exception("Pusiste cualquier cosa nada que ver jajaja");
        }
    }

}

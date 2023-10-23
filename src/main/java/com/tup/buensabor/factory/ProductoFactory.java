package com.tup.buensabor.factory;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.entities.ProductoInsumo;
import com.tup.buensabor.request.ProductRequest;

public class ProductoFactory {

    public Producto crearProducto(ProductRequest productRequest) throws Exception{
        if(productRequest.getTipoProducto().equals("Cocina")){
            return new ProductoCocina();
        } else if (productRequest.getTipoProducto().equals("Insumo")) {
            return new ProductoInsumo();
        } else {
            throw new Exception("Pusiste cualquier cosa nada que ver jajaja");
        }
    }

}

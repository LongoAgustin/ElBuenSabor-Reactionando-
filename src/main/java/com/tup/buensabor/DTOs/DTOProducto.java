package com.tup.buensabor.DTOs;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.RubroProducto;

import java.math.BigDecimal;
import java.util.List;

public class DTOProducto {
    private List<Producto> productos;

    public void addProducto(Producto producto){
        this.productos.add(producto);
    }

    public void setProductos(List<Producto> productList){
        this.productos = productList;
    }

}

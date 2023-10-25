package com.tup.buensabor.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOCarritoCompra {

    private BigDecimal total;

    @OneToMany(cascade = CascadeType.ALL)
    List<DTODetalleCarritoCompra> dtoDetalleCarritoCompras=new ArrayList<>();

    public void calcularMontoTotal (){
        BigDecimal montoTotal = BigDecimal.ZERO;  //Inicializar en cero
        for (DTODetalleCarritoCompra detalle: dtoDetalleCarritoCompras) {
           montoTotal = montoTotal.add(detalle.getSubtotal()) ; //Usa add para sumar
        }
        total = montoTotal;
    }
    public void addCarrito(DTODetalleCarritoCompra carrito){
        this.dtoDetalleCarritoCompras.add(carrito);
        this.calcularMontoTotal();
    }
}

package com.tup.buensabor.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DTODetalleCarritoCompra {

    private String denominacion;
    private String urlImagen;
    private BigDecimal precioVenta;
    private Integer cantidad;
    private BigDecimal subtotal;


}

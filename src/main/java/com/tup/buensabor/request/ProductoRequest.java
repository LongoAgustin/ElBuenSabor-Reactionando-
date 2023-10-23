package com.tup.buensabor.request;

import com.tup.buensabor.enums.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

    private String tipoProducto;

    private String denominacion;

    private String descripcion;

    private BigDecimal precio;

    private Integer tiempoEstimadoCocina;

    private String marca;

    private Integer lote;

    private EstadoProducto estadoProducto;

}

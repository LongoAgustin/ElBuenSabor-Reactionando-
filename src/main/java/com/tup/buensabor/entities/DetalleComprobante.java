package com.tup.buensabor.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleComprobante extends Base {

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_articulo_producto")
    private ArticuloProducto articuloProducto;

}

package com.tup.buensabor.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedido extends Base {

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "subtotal_costo", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotalCosto;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_articulo_manufacturado")
    private ArticuloProducto articuloProducto;


}

package com.tup.buensabor.entities.Pedido;

import com.tup.buensabor.entities.Base;
import com.tup.buensabor.entities.Producto.Producto;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "subtotal_costo", precision = 10, scale = 2, nullable = true)
    private BigDecimal subtotalCosto;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_articulo_manufacturado")
    private Producto producto;


}

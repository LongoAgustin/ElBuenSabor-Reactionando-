package com.tup.buensabor.entities.Comprobante;

import com.tup.buensabor.entities.Base;
import com.tup.buensabor.entities.Producto.Producto;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_comprobante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleComprobante extends Base {

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne()
    @JoinColumn(name = "fk_articulo_producto")
    private Producto producto;



}

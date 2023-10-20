package com.tup.buensabor.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_producto_cocina")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleProductoCocina extends Base {

    @Column(name = "cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "fk_articulo_insumo")
    private Ingrediente ingrediente;


}

package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_nota_credito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleNotaCredito extends Base{

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk-Articulo-Producto")
    private ArticuloProducto articuloProducto;

}

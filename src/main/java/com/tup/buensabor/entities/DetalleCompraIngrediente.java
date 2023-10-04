package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_Compra_Ingredientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleCompraIngrediente extends Base{

    @Column(name = "cantidadComprada")
    private int cantidadComprada;

    @Column(name = "precioCompra")
    private BigDecimal precioCompra;

    @Column(name = "subTotalCompra")
    private BigDecimal subTotalCompra;

    @ManyToOne()
    @JoinColumn(name = "fk_Articulo_Ingrediente")
    private ArticuloIngrediente articuloIngrediente;


}

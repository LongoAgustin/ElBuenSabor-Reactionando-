package com.tup.buensabor.entities.Ingrediente;

import com.tup.buensabor.entities.Base;
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
public class DetalleCompraIngrediente extends Base {

    @Column(name = "cantidad_comprada")
    private int cantidadComprada;

    @Column(name = "precio_compra")
    private BigDecimal precioCompra;

    @Column(name = "subtotal_compra")
    private BigDecimal subTotalCompra;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_articulo_ingrediente")
    private Ingrediente ingrediente;


}

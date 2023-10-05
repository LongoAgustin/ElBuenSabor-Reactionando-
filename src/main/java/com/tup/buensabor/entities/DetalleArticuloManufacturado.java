package com.tup.buensabor.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleArticuloManufacturado extends Base {


    @Column(name = "cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;


    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_articulo_insumo")
    private ArticuloIngrediente articuloIngrediente;


}

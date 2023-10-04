package com.tup.buensabor.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "articulo_ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloIngrediente extends Base {

    @NotNull
    @Column(name = "denominacion")
    private String denominacion;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @NotNull
    @Column(name = "precio_compra", precision = 10, scale = 2)
    private BigDecimal precioCompra;

    @NotNull
    @Column(name = "stock_actual", precision = 10, scale = 2)
    private BigDecimal stockActual;

    @NotNull
    @Column(name = "stock_minimo", precision = 10, scale = 2)
    private BigDecimal stockMinimo;

    @Column(name = "url_imagen")
    private String urlImagen;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "fk_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne()
    @JoinColumn(name = "fk_rubro_articulo_ingrediente")
    private RubroArticuloIngrediente rubroArticuloIngrediente;

}

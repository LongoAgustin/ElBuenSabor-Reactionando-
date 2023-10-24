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
@Table(name = "ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ingrediente extends Base {

    @NotNull
    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "fecha_hora_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAlta;

    @Column(name = "fecha_hora_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraBaja;

    @Column(name = "fecha_hora_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModificacion;

    @Column(name = "precio_compra", precision = 10, scale = 2)
    private BigDecimal precioCompra;

    @Column(name = "stock_actual", precision = 10, scale = 2)
    private BigDecimal stockActual;

    @Column(name = "stock_minimo", precision = 10, scale = 2)
    private BigDecimal stockMinimo;

    @Column(name = "url_imagen")
    private String urlImagen;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_unidad_medida")
    private UnidadMedida unidadMedida;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_rubro_articulo_ingrediente")
    private RubroIngrediente rubroIngrediente;

}

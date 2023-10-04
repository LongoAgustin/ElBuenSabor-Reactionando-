package com.tup.buensabor.entities;

import com.tup.buensabor.enums.TipoProducto;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "articulo_producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ArticuloProducto extends Base {

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

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
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoProducto tipoProducto;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @OneToMany()
    @JoinColumn(name = "fk_detalleArticuloFacturado")
    private DetalleArticuloManufacturado detalleArticuloManufacturado;

    @ManyToOne
    @JoinColumn(name = "fk_rubroArticuloProducto")
    private RubroArticuloProducto rubroarticuloproducto;

}

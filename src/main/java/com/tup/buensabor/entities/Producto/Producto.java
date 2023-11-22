package com.tup.buensabor.entities.Producto;

import com.tup.buensabor.entities.Base;
import com.tup.buensabor.enums.EstadoProducto;
import com.tup.buensabor.enums.TipoProducto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//Indicamos que es una herencia
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminador_producto")
public class Producto extends Base {

    @Column(nullable = false, name = "denominacion")
    private String denominacion;

    @Column(length = 1000)
    private String descripcion;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "estado_producto")
    @Enumerated
    private EstadoProducto estadoProducto;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(cascade =  CascadeType.REFRESH)
    @JoinColumn(name = "fk_rubroProducto", nullable = true)
    private RubroProducto rubroProducto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_producto")
    private TipoProducto tipoProducto;
}

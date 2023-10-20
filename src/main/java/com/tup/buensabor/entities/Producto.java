package com.tup.buensabor.entities;

import com.tup.buensabor.enums.TipoProducto;
import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Producto extends Base {

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(nullable = false, name = "denominacion")
    private String denominacion;

    @Column(length = 1000)
    private String descripcion;

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_producto")
    private TipoProducto tipoProducto;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_detalleArticuloFacturado")
    private List<DetalleProductoCocina> detalleProductoCocinas = new ArrayList<>();

    public void addDetalleArticuloManufacturado(DetalleProductoCocina detalleProductoCocina){
        this.detalleProductoCocinas.add(detalleProductoCocina);
    }

    @ManyToOne(cascade =  CascadeType.REFRESH)
    @JoinColumn(name = "fk_rubroArticuloProducto")
    private RubroProducto rubroarticuloproducto;

}

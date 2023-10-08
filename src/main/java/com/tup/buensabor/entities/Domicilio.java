package com.tup.buensabor.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domicilio extends Base {

    @Column(name = "user")
    private Usuario user;

    @Column(name = "calle" ,length = 500, nullable = false)
    private String calle;

    @Column(precision = 4, name = "codigo_postal", nullable = false)
    private Integer codigoPostal;

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(precision = 5, name = "numero")
    private Integer numero;

    @Column(name = "numero_dpto")
    private Integer numeroDpto;

    @Column(name = "piso_dpto")
    private Integer pisoDpto;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

}

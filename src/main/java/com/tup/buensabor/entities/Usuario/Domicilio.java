package com.tup.buensabor.entities.Usuario;

import com.tup.buensabor.entities.Base;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domicilio extends Base {

    @Column(name = "calle" ,length = 500, nullable = false)
    private String calle;

    @Column(precision = 4, name = "codigo_postal", nullable = false)
    private Integer codigoPostal;

    @Column(name = "fecha_hora_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAlta;

    @Column(name = "fecha_hora_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraBaja;

    @Column(name = "fecha_hora_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModificacion;

    @Column(precision = 5, name = "numero")
    private Integer numero;

    @Column(name = "numero_dpto")
    private Integer numeroDpto;

    @Column(name = "piso_dpto")
    private Integer pisoDpto;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_persona")
    private Persona persona;

}

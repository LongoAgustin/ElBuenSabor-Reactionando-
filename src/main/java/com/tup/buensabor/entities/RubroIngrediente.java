package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "rubro_ingrediente")
public class RubroIngrediente extends Base{

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


}

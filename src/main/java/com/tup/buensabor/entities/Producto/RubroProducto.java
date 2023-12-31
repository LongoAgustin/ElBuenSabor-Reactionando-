package com.tup.buensabor.entities.Producto;


import com.tup.buensabor.entities.Base;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "rubro_producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RubroProducto extends Base {

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

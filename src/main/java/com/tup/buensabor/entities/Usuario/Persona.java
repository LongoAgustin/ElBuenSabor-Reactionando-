package com.tup.buensabor.entities.Usuario;

import com.tup.buensabor.entities.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "persona")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona extends Base {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fecha_hora_alta")
    private Date fechaHoraAlta;
    @Column(name = "fecha_hora_baja")
    private Date fechaHoraBaja;
    @Column(name = "fecha_hora_modificacion")
    private Date fechaHoraModificacion;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

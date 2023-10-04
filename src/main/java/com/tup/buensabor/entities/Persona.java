package com.tup.buensabor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "persona")
public class Persona extends Base{

    @NotNull
    @Column(name = "apellido")
    private String apellido;
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "telefono")
    private String telefono;


}

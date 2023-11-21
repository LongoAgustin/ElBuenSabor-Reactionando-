package com.tup.buensabor.Auth;

import com.tup.buensabor.enums.Rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    String email;
    String password;
    String nombre;
    String apellido;
    String telefono;
    Rol rolUsuario;

}

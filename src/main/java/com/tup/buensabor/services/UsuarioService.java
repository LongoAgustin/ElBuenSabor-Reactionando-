package com.tup.buensabor.services;

import com.tup.buensabor.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService extends BaseService<Usuario, Long>{

    public Usuario registrarUsuario(Usuario usuario) throws Exception;

    public Usuario iniciarSesion(String email, String password) throws Exception;
}

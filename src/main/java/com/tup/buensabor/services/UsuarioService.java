package com.tup.buensabor.services;

import com.tup.buensabor.entities.Usuario;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Long>{

    public Usuario registrarUsuario(Usuario usuario) throws Exception;

    public Usuario iniciarSesion(String email, String password) throws Exception;
}

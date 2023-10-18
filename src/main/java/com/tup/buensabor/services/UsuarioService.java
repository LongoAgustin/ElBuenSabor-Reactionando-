package com.tup.buensabor.services;

import com.tup.buensabor.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long>{

    public Usuario registrarUsuario(Usuario usuario) throws Exception;
}

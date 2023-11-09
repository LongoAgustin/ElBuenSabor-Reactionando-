package com.tup.buensabor.services.UsuarioServices;

import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.services.BaseService;

public interface UsuarioService extends BaseService<Usuario, Long> {

    public Usuario registrarUsuario(Usuario usuario) throws Exception;

    public Usuario iniciarSesion(String email, String password) throws Exception;
}

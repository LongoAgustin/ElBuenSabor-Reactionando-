package com.tup.buensabor.services;

import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService{

    @Autowired
    protected UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario,Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception{
        try {
            List<Usuario> usuarioEncontrado = usuarioRepository.verificarEmail(usuario.getEmail());
            if (usuarioEncontrado.isEmpty()){
                usuarioRepository.save(usuario);
                return usuario;
            }
            else{
                throw new Exception("Este correo electrónico ya está utilizado");
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

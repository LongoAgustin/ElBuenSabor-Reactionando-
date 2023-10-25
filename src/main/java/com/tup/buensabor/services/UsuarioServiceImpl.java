package com.tup.buensabor.services;

import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.enums.Rol;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

                usuario.setFirst_login(LocalDateTime.now());
                usuario.setRol(Rol.CLIENTE);

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

    @Override
    public Usuario iniciarSesion(String email, String password) throws Exception {

        try {
            List<Usuario> usuarioEncontrado = usuarioRepository.iniciarSesion(email, password);
            if (usuarioEncontrado.isEmpty()){
                throw new Exception("No coinciden las credenciales");
            }
            else {
                return usuarioEncontrado.get(0);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


}

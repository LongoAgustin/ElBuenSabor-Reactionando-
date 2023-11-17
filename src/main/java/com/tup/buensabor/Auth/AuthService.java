package com.tup.buensabor.Auth;

import java.util.List;
import java.util.Optional;

import com.tup.buensabor.repositories.UsuarioRepository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tup.buensabor.JWT.JwtService;
import com.tup.buensabor.entities.Usuario.Persona;
import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.enums.Rol;
import com.tup.buensabor.repositories.UsuarioRepository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PersonaRepository personaRepository;

    JwtService jwt;

    public AuthResponse register(RegisterRequest request) throws Exception {
        try {
            Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(request.getEmail());
            
            if (usuarioEncontrado.isEmpty()){

                Usuario usuario = new Usuario();

                usuario.setEmail(request.getEmail());
                usuario.setPassword(request.getPassword());

                Persona persona = new Persona();

                persona.setApellido(request.getApellido());
                persona.setNombre(request.getNombre());
                persona.setTelefono(request.getTelefono());

                usuario.setPersona(persona);
                usuario.setRol(Rol.CLIENTE);

                usuarioRepository.save(usuario);
                personaRepository.save(persona);

                return new AuthResponse(jwt.getToken(usuario));
            }
            else{
                throw new Exception("Este correo electrónico ya está utilizado");
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public AuthResponse login(LoginRequest request){
        return null;
    }

}

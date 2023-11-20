package com.tup.buensabor.Auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tup.buensabor.JWT.JwtService;
import com.tup.buensabor.entities.Usuario.Persona;
import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.enums.Rol;
import com.tup.buensabor.repositories.UsuarioRepository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    JwtService jwt;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) throws Exception {
        try {
            Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(request.getEmail());
            
            if (usuarioEncontrado.isEmpty()){

                Usuario usuario = new Usuario();

                usuario.setEmail(request.getEmail());
                usuario.setPassword(passwordEncoder.encode(request.getPassword()));

                Persona persona = new Persona();

                persona.setApellido(request.getApellido());
                persona.setNombre(request.getNombre());
                persona.setTelefono(request.getTelefono());

                usuario.setPersona(persona);
                
                if (request.rolUsuario.equals(Rol.ADMIN)) {
                    usuario.setRol(Rol.ADMIN);
                } else if (request.rolUsuario.equals(Rol.EMPLEADO)) {
                    usuario.setRol(Rol.EMPLEADO);
                } else {
                    usuario.setRol(Rol.CLIENTE);
                }

                usuarioRepository.save(usuario);

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
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserDetails usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwt.getToken(usuario);
        return new AuthResponse(token);
    }

}

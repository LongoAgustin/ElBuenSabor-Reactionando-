package com.tup.buensabor.repositories.UsuarioRepository;

import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    @Query( value = "SELECT * FROM usuario WHERE usuario.email = :email_ingresado", nativeQuery = true )
    Optional<Usuario> findByEmail(@Param("email_ingresado") String email);

    @Query( value = "SELECT * FROM usuario WHERE usuario.email = :email_ingresado AND usuario.password = :password_ingresado",
            nativeQuery = true )
    List<Usuario> iniciarSesion(@Param("email_ingresado") String email, @Param("password_ingresado") String password);

}

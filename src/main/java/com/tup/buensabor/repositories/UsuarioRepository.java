package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    @Query( value = "SELECT * FROM usuario WHERE usuario.email = :email_ingresado", nativeQuery = true )
    List<Usuario> verificarEmail(@Param("email_ingresado") String email);

}

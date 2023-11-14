package com.tup.buensabor.repositories.UsuarioRepository;

import com.tup.buensabor.entities.Usuario.Persona;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
}

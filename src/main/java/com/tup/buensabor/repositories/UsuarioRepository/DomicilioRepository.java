package com.tup.buensabor.repositories.UsuarioRepository;

import com.tup.buensabor.entities.Usuario.Domicilio;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
}

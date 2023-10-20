package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
}

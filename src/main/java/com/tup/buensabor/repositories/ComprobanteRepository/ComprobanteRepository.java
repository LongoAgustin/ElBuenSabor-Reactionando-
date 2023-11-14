package com.tup.buensabor.repositories.ComprobanteRepository;

import com.tup.buensabor.entities.Comprobante.Comprobante;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends BaseRepository<Comprobante,Long> {
}

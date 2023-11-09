package com.tup.buensabor.repositories.ComprobanteRepository;

import com.tup.buensabor.entities.Comprobante.DetalleComprobante;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleComprobanteRepository extends BaseRepository<DetalleComprobante, Long> {
}

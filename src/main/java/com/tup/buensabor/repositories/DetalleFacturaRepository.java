package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.DetalleComprobante;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleComprobante, Long> {
}

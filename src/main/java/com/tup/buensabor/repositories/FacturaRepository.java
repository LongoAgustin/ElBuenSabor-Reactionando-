package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Factura;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {
}

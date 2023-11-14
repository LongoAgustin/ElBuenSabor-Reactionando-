package com.tup.buensabor.repositories.ComprobanteRepository;

import com.tup.buensabor.entities.Comprobante.NotaCredito;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaCreditoRepository extends BaseRepository<NotaCredito, Long> {
}

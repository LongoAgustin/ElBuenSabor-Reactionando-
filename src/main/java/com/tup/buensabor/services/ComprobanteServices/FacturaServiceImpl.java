package com.tup.buensabor.services.ComprobanteServices;

import com.tup.buensabor.entities.Comprobante.Factura;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ComprobanteRepository.FacturaRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {

    @Autowired
    protected FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura,Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository = facturaRepository;
    }

    public void emitirFacturas() {
        List<Factura[]> pedidosParaFacturar = facturaRepository.obtenerPedidoParaFacturar();
        for (Object[] pedidoInfo : pedidosParaFacturar) {
            Long pedidoId = (Long) pedidoInfo[0];
            Long clienteId = (Long) pedidoInfo[1];
        }
    }
}

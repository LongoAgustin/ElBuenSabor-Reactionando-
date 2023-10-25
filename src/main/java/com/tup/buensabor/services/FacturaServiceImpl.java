package com.tup.buensabor.services;

import com.tup.buensabor.entities.Factura;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService{

    @Autowired
    protected FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura,Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository = facturaRepository;
    }

    public void emitirFacturasParaClienteAgustin() {
        List<Factura[]> pedidosParaFacturar = facturaRepository.obtenerPedidoParaFacturar();
        for (Object[] pedidoInfo : pedidosParaFacturar) {
            Long pedidoId = (Long) pedidoInfo[0];
            Long clienteId = (Long) pedidoInfo[1];
        }
    }
}

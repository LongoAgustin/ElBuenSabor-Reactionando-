package com.tup.buensabor.services;

import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DetallePedidoServiceImpl  extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService{

    @Autowired
    protected DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido,Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {
        super(baseRepository);
        this.detallePedidoRepository = detallePedidoRepository;
    }
}

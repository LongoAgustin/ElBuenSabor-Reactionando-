package com.tup.buensabor.services;

import com.tup.buensabor.entities.PedidoEstadoPedido;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.PedidoEstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoEstadoPedidoServiceImpl extends BaseServiceImpl<PedidoEstadoPedido, Long> implements PedidoEstadoPedidoService{

    @Autowired
    protected PedidoEstadoPedidoRepository pedidoEstadoPedidoRepository;

    public PedidoEstadoPedidoServiceImpl(BaseRepository<PedidoEstadoPedido,Long> baseRepository, PedidoEstadoPedidoRepository pedidoEstadoPedidoRepository) {
        super(baseRepository);
        this.pedidoEstadoPedidoRepository = pedidoEstadoPedidoRepository;
    }
}

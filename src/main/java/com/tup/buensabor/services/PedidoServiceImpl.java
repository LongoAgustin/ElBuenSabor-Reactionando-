package com.tup.buensabor.services;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService{

    @Autowired
    protected PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido,Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }
}

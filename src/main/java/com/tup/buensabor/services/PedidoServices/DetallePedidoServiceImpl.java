package com.tup.buensabor.services.PedidoServices;

import com.tup.buensabor.DTO.DTOProductoPedido;
import com.tup.buensabor.entities.Pedido.DetallePedido;
import com.tup.buensabor.entities.Producto.Producto;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.PedidoRepository.DetallePedidoRepository;
import com.tup.buensabor.repositories.ProductoRepository.ProductoRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl  extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    protected Producto producto;
    @Autowired
    protected DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {
        super(baseRepository);
        this.detallePedidoRepository = detallePedidoRepository;
    }

}


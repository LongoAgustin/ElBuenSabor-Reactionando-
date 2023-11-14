package com.tup.buensabor.repositories.PedidoRepository;

import com.tup.buensabor.entities.Pedido.DetallePedido;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long> {
}

package com.tup.buensabor.services;

import com.tup.buensabor.DTO.DTOPedidos;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.enums.EstadoPedido;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    public List<Pedido> searchXUsuario(Long usuarioid) throws Exception;
    public List<DTOPedidos> listaXEstados(String estado) throws Exception;

}

package com.tup.buensabor.services;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Usuario;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    public List<Pedido> searchXUsuario(Long usuarioid) throws Exception;




}

package com.tup.buensabor.services.PedidoServices;

import com.tup.buensabor.DTO.DTOPedidoABM;
import com.tup.buensabor.DTO.DTOPedidoRequest;
import com.tup.buensabor.DTO.DTOPedidos;
import com.tup.buensabor.entities.Comprobante.Factura;
import com.tup.buensabor.entities.Pedido.Pedido;
import com.tup.buensabor.services.BaseService;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    public List<Pedido> searchXUsuario(Long usuarioid) throws Exception;
    public List<DTOPedidos> listaXEstados(String estado) throws Exception;
    public Factura pagarPedido(Long idPedido) throws Exception;
    public Pedido searchxID(Long pedidoID) throws Exception;
    public String cambioEstado(DTOPedidoRequest dtoPedidoRequest) throws Exception;
    public Pedido newPedido(DTOPedidoABM dtoPedidoABM)throws Exception;
}

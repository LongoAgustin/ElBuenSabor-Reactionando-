package com.tup.buensabor.services;

import com.tup.buensabor.DTO.DTOPedidos;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.PedidoRepository;
import com.tup.buensabor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    protected PedidoRepository pedidoRepository;

    @Autowired
    protected UsuarioRepository usuarioRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> searchXUsuario(Long usuarioid) throws Exception {
        try {
            Optional<Usuario> user = usuarioRepository.findById(usuarioid);
            if (user.isEmpty()) {
                throw new Exception("No Existe el Usuario");
            } else {
                List<Pedido> pedidos = user.get().getPedidoList();
                return pedidos;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



    public List<DTOPedidos> getlistaPedidos() throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            List<DTOPedidos> pedidosDTO = new ArrayList<>();
            for (Pedido pedido : pedidos) {
                DTOPedidos pedidoDTO = new DTOPedidos(pedido.getId(), pedido.getFechaHoraAlta(), pedido.getTipoEnvio(), pedido.getEstado());
                pedidosDTO.add(pedidoDTO);

            }
            return pedidosDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }


    public List<DTOPedidos> listaXEstados(EstadoPedido estadoPedido) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.findByEstado(estadoPedido);
            List<DTOPedidos> pedidosDTO = new ArrayList<>();

            for (Pedido pedido : pedidos) {
                if (pedido.getEstado() == estadoPedido) {
                    DTOPedidos pedidoDTO = new DTOPedidos(pedido.getId(), pedido.getFechaHoraAlta(), pedido.getTipoEnvio(), pedido.getEstado());
                    pedidosDTO.add(pedidoDTO);
                }
            }
            return pedidosDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
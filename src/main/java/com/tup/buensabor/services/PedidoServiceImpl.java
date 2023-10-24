package com.tup.buensabor.services;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.PedidoRepository;
import com.tup.buensabor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService{

    @Autowired
    protected PedidoRepository pedidoRepository;

    @Autowired
    protected UsuarioRepository usuarioRepository;

    public PedidoServiceImpl(BaseRepository<Pedido,Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> searchXUsuario(Long usuarioid) throws Exception{
        try{
            Optional<Usuario> user=usuarioRepository.findById(usuarioid);
            if(user.isEmpty()){
                throw new Exception("No Existe el Usuario");
            }else {
                List<Pedido> pedidos=user.get().getPedidoList();
                return pedidos;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}

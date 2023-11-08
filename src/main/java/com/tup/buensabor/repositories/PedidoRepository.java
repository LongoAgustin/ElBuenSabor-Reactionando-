package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.enums.EstadoPedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM pedido WHERE pedido.estado LIKE %:filtro%", nativeQuery = true)
    List<Pedido> findByEstado(@Param("filtro") String filtro);


}

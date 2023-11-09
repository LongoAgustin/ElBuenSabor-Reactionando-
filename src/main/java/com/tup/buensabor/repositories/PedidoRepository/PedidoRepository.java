package com.tup.buensabor.repositories.PedidoRepository;

import com.tup.buensabor.entities.Pedido.Pedido;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    @Query( value = "SELECT * FROM pedido WHERE pedido.estado LIKE %:filtro%", nativeQuery = true)

    List<Pedido> findByEstado(@Param("filtro") String filtro);

}

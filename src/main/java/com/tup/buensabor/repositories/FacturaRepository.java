package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {
    @Query(value = "SELECT p.id as pedido_id, c.id as cliente_id, f.id as factura_id " +
            "FROM Pedido p " +
            "JOIN Cliente c ON p.cliente_id = c.id " +
            "LEFT JOIN Factura f ON p.id = f.pedido_id " +
            "WHERE c.nombre = 'Agustin' AND p.estado = 'COBRADO' AND f.id IS NULL", nativeQuery = true)
    List<Factura[]> obtenerPedidoParaFacturar();



}

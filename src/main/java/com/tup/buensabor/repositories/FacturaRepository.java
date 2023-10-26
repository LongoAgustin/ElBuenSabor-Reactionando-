package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    //En esta consulta, se seleccionan los ID del pedido, el cliente y la factura de las tablas correspondientes (reemplaza Pedido, Cliente, y Factura con los nombres reales de tus entidades).
    // La consulta realiza una unión (JOIN) entre las tablas Pedido y Cliente, y una unión izquierda (LEFT JOIN) con la tabla Factura. Luego, se aplican condiciones para que el cliente se llame "Agustin", el estado del pedido sea "pagado" y no haya una factura asociada al pedido.
    @Query(value = "SELECT p.id as pedido_id, c.id as cliente_id, f.id as factura_id " +
            "FROM Pedido p " +
            "JOIN Cliente c ON p.cliente_id = c.id " +
            "LEFT JOIN Factura f ON p.id = f.pedido_id " +
            "WHERE c.nombre = 'Agustin' AND p.estado = 'COBRADO' AND f.id IS NULL", nativeQuery = true)
    List<Factura[]> obtenerPedidoParaFacturar();



}

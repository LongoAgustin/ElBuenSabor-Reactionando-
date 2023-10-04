package com.example.demo.repositories;


import com.tup.buensabor.entities.PedidoEstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoEstadoPedidoRepository extends JpaRepository<PedidoEstadoPedido, Long> {
}

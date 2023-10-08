package com.tup.buensabor.entities;

import com.tup.buensabor.enums.EstadoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "pedido_estado_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoEstadoPedido extends Base {

    @Column(name = "estado_pedido")
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    @Column(name = "fecha_hora_cambio_estado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCambioEstado;

    @Column(name = "fk_pedido")
    private Pedido pedido;

}

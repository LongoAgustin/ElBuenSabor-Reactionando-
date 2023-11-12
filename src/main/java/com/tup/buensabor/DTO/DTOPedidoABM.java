package com.tup.buensabor.DTO;

import com.tup.buensabor.entities.Pedido.DetallePedido;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.FormaPago;
import com.tup.buensabor.enums.TipoEnvio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOPedidoABM {

    private long id;
    private EstadoPedido estadoPedido;
    private Date fechaHoraAlta;
    private FormaPago formaPago;
    private Date horaEstimadaFinalizacion;
    private TipoEnvio tipoEnvio;
    private BigDecimal total;
    private List<DetallePedido> detallePedidoList;
}

package com.tup.buensabor.DTO;

import com.tup.buensabor.entities.Pedido.DetallePedido;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.FormaPago;
import com.tup.buensabor.enums.TipoEnvio;
import com.tup.buensabor.enums.TipoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOProductoPedido {

    private Long id;
    private EstadoPedido estadoPedido;
    private Date fechaHoraAlta;
    private FormaPago formaPago;
    private TipoEnvio tipoEnvio;
    private BigDecimal total;
    private List<DetallePedido> detallePedidoList;

}

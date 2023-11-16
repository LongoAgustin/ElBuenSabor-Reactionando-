package com.tup.buensabor.DTO;

import com.tup.buensabor.enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOPedidoRequest {
    private Long id;
    private EstadoPedido estadoPedido;

}

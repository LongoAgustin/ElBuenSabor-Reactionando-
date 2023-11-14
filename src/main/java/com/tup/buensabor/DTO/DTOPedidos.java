package com.tup.buensabor.DTO;

import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.TipoEnvio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOPedidos {
    private long id;
    private Date fechaHoraAlta;
    private TipoEnvio tipoEnvio;
    private EstadoPedido estadoPedido;

}

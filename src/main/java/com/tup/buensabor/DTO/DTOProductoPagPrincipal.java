package com.tup.buensabor.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOProductoPagPrincipal {
    private String denominacion;

    private String categoria;

    private BigDecimal precio;

    private String url;

    private Boolean disponibilidad;
}

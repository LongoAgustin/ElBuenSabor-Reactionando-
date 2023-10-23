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
public class DTOReceta {

    private BigDecimal cantidad;

    private String denominacionIngrediente;

    private String unidadMedidaDenominacion;

    private String unidadMedidaAbreviatura;

}

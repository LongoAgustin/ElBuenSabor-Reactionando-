package com.tup.buensabor.DTO;

import java.math.BigDecimal;

import com.tup.buensabor.entities.Ingrediente.RubroIngrediente;
import com.tup.buensabor.entities.Ingrediente.UnidadMedida;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOIngrediente {
    Long id;
    String denominacion;
    BigDecimal precio;
    BigDecimal stockActual;
    BigDecimal stockMinimo;
    String urlImagen;
    UnidadMedida unidadMedida;
    RubroIngrediente rubroIngrediente;
}

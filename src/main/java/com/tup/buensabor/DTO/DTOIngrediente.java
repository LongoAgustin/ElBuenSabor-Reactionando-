package com.tup.buensabor.DTO;

import com.tup.buensabor.entities.Ingrediente.RubroIngrediente;
import com.tup.buensabor.entities.Ingrediente.UnidadMedida;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOIngrediente {

    private Long id;

    private String denominacion;

    private Date fechaHoraAlta;

    private Date fechaHoraBaja;

    private Date fechaHoraModificacion;

    private BigDecimal precioCompra;

    private BigDecimal stockActual;

    private BigDecimal stockMinimo;

    private String urlImagen;

    private UnidadMedida unidadMedida;

    private RubroIngrediente rubroIngrediente;
}

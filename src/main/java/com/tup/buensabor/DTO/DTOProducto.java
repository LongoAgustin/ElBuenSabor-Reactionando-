package com.tup.buensabor.DTO;

import com.tup.buensabor.entities.Producto.DetalleProductoCocina;
import com.tup.buensabor.entities.Producto.RubroProducto;
import com.tup.buensabor.enums.EstadoProducto;
import com.tup.buensabor.enums.TipoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOProducto {

    private Long id;

    private String tipoProducto;

    private String denominacion;

    private String descripcion;

    private BigDecimal precio;

    private Integer tiempoEstimadoCocina;

    private String marca;

    private Integer lote;

    private EstadoProducto estadoProducto;

    private List<DetalleProductoCocina> detalleProductoCocinaList;

    private RubroProducto rubroProducto;

    private String urlImagen;

}

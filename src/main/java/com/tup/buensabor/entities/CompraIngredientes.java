package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CompraIngredientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompraIngredientes extends Base{

    @Column(name = "costo-Total-Compra")
    private BigDecimal costoTotalCompra;

    @Column(name = "fecha-Hora-Compra-Ingredientes")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCompraIngredientes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_DetalleCompraIngredientes")
    private List<DetalleCompraIngrediente> detalleCompraIngrediente = new ArrayList<>();

}

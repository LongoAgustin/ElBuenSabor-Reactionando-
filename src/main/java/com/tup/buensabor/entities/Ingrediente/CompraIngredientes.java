package com.tup.buensabor.entities.Ingrediente;

import com.tup.buensabor.entities.Base;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compra_ingredientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompraIngredientes extends Base {

    @Column(name = "costo-Total-Compra")
    private BigDecimal costoTotalCompra;

    @Column(name = "fecha-Hora-Compra-Ingredientes")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCompraIngredientes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_DetalleCompraIngredientes")
    private List<DetalleCompraIngrediente> detalleCompraIngrediente = new ArrayList<>();

    public void addDetalleCompraIngrediente(DetalleCompraIngrediente detalleCompraIngrediente){
        this.detalleCompraIngrediente.add((detalleCompraIngrediente));
    }
}

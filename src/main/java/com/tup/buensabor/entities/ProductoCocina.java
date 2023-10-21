package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "producto_cocina")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoCocina extends Producto {

    @OneToMany(cascade = CascadeType.ALL)
    private List<DetalleProductoCocina> detalleProductoCocina;

    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

}

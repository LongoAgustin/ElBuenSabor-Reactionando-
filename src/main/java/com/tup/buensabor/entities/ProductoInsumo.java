package com.tup.buensabor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DiscriminatorValue("Insumo")

public class ProductoInsumo extends Producto{

    @Column(name = "marca")
    public String marca;

    @Column(name = "lote")
    public Integer lote;

    @Column
    public Integer stock;

}

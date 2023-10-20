package com.tup.buensabor.entities;

import com.tup.buensabor.enums.Rol;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class Usuario extends Base {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private Rol rol; //Asignar al registrar

    @Column(name = "first_login")
    private LocalDateTime first_login; //Asignar al registrar

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_pedido")
    private List<Pedido> pedidoList;

    public void addPedidoList(Pedido pedido){ pedidoList.add(pedido); }


    //Saco AUTH0

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaBaja;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaModificacion;


}

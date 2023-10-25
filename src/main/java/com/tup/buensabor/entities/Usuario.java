package com.tup.buensabor.entities;

import com.tup.buensabor.enums.Rol;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class Usuario extends Base {

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column(name = "first_login")
    private LocalDateTime first_login; //Asignar al registrar

    //Saco AUTH0

    @Column(name = "fecha_hora_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaHoraAlta;

    @Column(name = "fecha_hora_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaHoraBaja;

    @Column(name = "fecha_hora_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaHoraModificacion;

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_pedido")
    private List<Pedido> pedidoList=new ArrayList<>();

    public void addPedidoList(Pedido pedido){ pedidoList.add(pedido); }

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_persona")
    public Persona persona;


}

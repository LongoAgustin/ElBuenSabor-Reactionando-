package com.tup.buensabor.entities.Usuario;

import com.tup.buensabor.entities.Base;
import com.tup.buensabor.entities.Pedido.Pedido;
import com.tup.buensabor.enums.Rol;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class Usuario extends Base implements UserDetails{

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pedido")
    private List<Pedido> pedidoList=new ArrayList<>();

    public void addPedidoList(Pedido pedido){ pedidoList.add(pedido); }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_persona")
    public Persona persona;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public String getUsername() {
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}

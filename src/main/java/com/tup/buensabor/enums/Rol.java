package com.tup.buensabor.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Rol implements GrantedAuthority {
    ADMIN,
    CLIENTE,
    EMPLEADO;

    @Override
    public String getAuthority() {
        return this.name();
    }
}

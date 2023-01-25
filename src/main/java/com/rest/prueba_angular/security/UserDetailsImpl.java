package com.rest.prueba_angular.security;

import com.rest.prueba_angular.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {


    private final Usuario usuario;

    /**
     * Util pora permisos o roles pero retornaremos una lista vacia
     *
     * @return
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    /**
     * @return
     */
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    /**
     * configurar para cambiar de usuario o email
     *
     * @return
     */
    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    // <editor-fold defaultstate="collapsed" desc="Metodos para controles de acceso">

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    // </editor-fold>
    public String getNombre() {
        return usuario.getNombre();
    }
}

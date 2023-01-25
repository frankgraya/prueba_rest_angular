package com.rest.prueba_angular.security;

import com.rest.prueba_angular.model.Usuario;
import com.rest.prueba_angular.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    /**
     * @param email ESTE PARAMETRO SE PUEDE MODIFICAR PARA QUE SEA POR USUARIO
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("usuario con email no existe" + email));
        return new UserDetailsImpl(usuario);
    }
}

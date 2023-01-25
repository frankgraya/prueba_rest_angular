package com.rest.prueba_angular.service;

import com.rest.prueba_angular.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario saveUsuario(Usuario usuario);

    public void deleteUsuario(long id);

    public Usuario findByIdUsuario(long id);

    public List<Usuario> findAllUsuario();

}

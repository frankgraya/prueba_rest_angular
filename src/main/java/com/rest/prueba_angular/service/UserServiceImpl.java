package com.rest.prueba_angular.service;

import com.rest.prueba_angular.model.Usuario;
import com.rest.prueba_angular.repository.UserRepository;

import com.rest.prueba_angular.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        log.info("se guardo usuario" + usuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(long id) {
        usuarioRepository.deleteById(id);
        log.info("Se borro usuario con el id " + id);
    }

    @Override
    public Usuario findByIdUsuario(long id) {

        Optional<Usuario> optional = usuarioRepository.findById(id);

        Usuario usuario = null;
        if (((Optional<?>) optional).isPresent()) {
            usuario = optional.get();
        } else {
            throw new RuntimeException(" Usuario no se encontro por id : " + id);
        }

        log.info("se veb rodos los usuarios");
        return usuario;

    }

    @Override
    public List<Usuario> findAllUsuario() {
        log.info(" Se encontraron todos los usuarios" + usuarioRepository.findAll());
        return usuarioRepository.findAll();
    }
}

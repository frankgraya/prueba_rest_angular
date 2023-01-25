package com.rest.prueba_angular.controller;

import com.rest.prueba_angular.model.Usuario;
import com.rest.prueba_angular.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase define objetos tipo Usuario
 *
 * @author: Francisco granados
 * @version: undefine
 * Documentacion con swagger
 * @see https://www.baeldung.com/spring-rest-openapi-documentation
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
//http://localhost:4000/api/usuarios
public class UserRestController {

    //Campos de la clase UserRestController
    //Clase para obtener los servicios con inyeccion de dependencias
    @Autowired
    private UsuarioService usuarioService;

    /**
     * GetMapping Obtener datos
     * @Metodo para obtener todos los usuarios registrados en el api
     */
    @GetMapping("/usuarios")
    public List<Usuario> mostrarUsuarios() {
        log.info("se mostraron todos los usuarios con exito " + usuarioService.findAllUsuario());
        return usuarioService.findAllUsuario();
    }

    /**
     * PostMapping enviar datos
     *
     * @param usuario El parámetro user define el objeto User a enviar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    @PostMapping("/usuarios")
    public Usuario salvarUsuarios(@RequestBody Usuario usuario) {
        log.info("se guardo usuario con exito" + usuario.getNombre());
        return usuarioService.saveUsuario(usuario);
    }

    /**
     * GetMapping obtener datos
     * @param user El parámetro user define el objeto User a enviar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    @GetMapping("/usuarios/{id}")
    public Usuario mostrarPorID(@PathVariable Integer id) {
        log.info("se mostro con exito el id " + id);
        return usuarioService.findByIdUsuario(id);
    }

    /**
     * PutMapping Actualizar datos
     * @param usuario El parámetro user define el objeto User a enviar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    @PutMapping("/usuarioactualizar/{id}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
        Usuario usuarioActual = usuarioService.findByIdUsuario(id);
        usuarioActual.setNombre(usuario.getNombre());
        usuarioActual.setApellidos(usuario.getApellidos());
        usuarioActual.setPassword(usuario.getEmail());
        log.info("se actualizo usuario con exito" + usuarioActual);
        return usuarioService.saveUsuario(usuarioActual);
    }

    /**
     * PostMapping borrar datos
     * @param id El parámetro user define el objeto User a enviar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    @DeleteMapping("/borrarUsuario/{id}")
    public void borrarUsuario(@PathVariable(value = "id") long id) {
        log.info("se borro con exito el id " + id);
        this.usuarioService.deleteUsuario(id);
    }
}

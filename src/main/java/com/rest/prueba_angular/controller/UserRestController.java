package com.rest.prueba_angular.controller;

import com.rest.prueba_angular.model.User;
import com.rest.prueba_angular.service.UserService;
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
    private UserService userService;

    /**
     * GetMapping Obtener datos
     * @Metodo para obtener todos los usuarios registrados en el api
     */
    @GetMapping("/usuarios")
    public List<User> mostrarUsuarios() {
        log.info("se mostraron todos los usuarios con exito " + userService.findAllUser());
        return userService.findAllUser();
    }

    /**
     * PostMapping enviar datos
     *
     * @param user El parámetro user define el objeto User a enviar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    @PostMapping("/usuarios")
    public User salvarUsuarios(@RequestBody User user) {
        log.info("se guardo usuario con exito" + user.getNombre());
        return userService.saveUser(user);
    }

    /**
     * GetMapping obtener datos
     * @param user El parámetro user define el objeto User a enviar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    @GetMapping("/usuarios/{id}")
    public User mostrarPorID(@PathVariable Integer id) {
        log.info("se mostro con exito el id " + id);
        return userService.findByIdUser(id);
    }

    /**
     * PutMapping Actualizar datos
     * @param user El parámetro user define el objeto User a enviar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    @PutMapping("/usuarioactualizar/{id}")
    public User actualizarUsuario(@RequestBody User user, @PathVariable Integer id) {
        User userActual = userService.findByIdUser(id);
        userActual.setNombre(user.getNombre());
        userActual.setApellidos(user.getApellidos());
        userActual.setPassword(user.getEmail());
        log.info("se actualizo usuario con exito" + userActual);
        return userService.saveUser(userActual);
    }

    /**
     * PostMapping borrar datos
     * @param id El parámetro user define el objeto User a enviar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    @DeleteMapping("/borrarUsuario/{id}")
    public void borrarUsuario(@PathVariable(value = "id") long id) {
        log.info("se borro con exito el id " + id);
        this.userService.deleteUser(id);
    }
}

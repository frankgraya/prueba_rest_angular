package com.rest.prueba_angular.controller;

import com.rest.prueba_angular.model.User;
import com.rest.prueba_angular.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
//http://localhost:4000/api/usuarios
public class UserRestController {


    @Autowired
    private UserService userService;


    /**
     * @Metodo para obtener todos los usuarios registrados en el api
     */
    @GetMapping("/usuarios")
    public List<User> user(){
        return userService.findAllUser();
    }
}

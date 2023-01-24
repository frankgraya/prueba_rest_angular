package com.rest.prueba_angular.controller;

import com.rest.prueba_angular.model.Contactos;
import com.rest.prueba_angular.model.User;
import com.rest.prueba_angular.repository.ContactosRepository;
import com.rest.prueba_angular.service.ContactosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("contactos")
public class ContactosRestController {
    @Autowired
    private ContactosRepository contactosRepository;


    @Autowired
    private ContactosService contactosService;

    @GetMapping
    public List<Contactos> mostrarContactos() {
        log.info("se mostraron todos los contactos con exito " + contactosService.findAllContactos());
        return contactosService.findAllContactos();
    }
}

package com.rest.prueba_angular.service;

import com.rest.prueba_angular.model.Contactos;

import java.util.List;

public interface ContactosService {

    public Contactos saveUser(Contactos contactos);

    public void deleteContactos(long id);

    public Contactos findByIdContactos(long id);

    public List<Contactos> findAllContactos();
}

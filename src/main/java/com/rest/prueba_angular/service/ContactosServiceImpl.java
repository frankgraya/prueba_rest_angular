package com.rest.prueba_angular.service;

import com.rest.prueba_angular.model.Contactos;
import com.rest.prueba_angular.model.User;
import com.rest.prueba_angular.repository.ContactosRepository;
import com.rest.prueba_angular.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactosServiceImpl implements ContactosService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ContactosRepository contactosRepository;

    @Override
    public Contactos saveUser(Contactos contactos) {
        log.info("se guardo contactos" + contactos);
        return contactosRepository.save(contactos);
    }

    @Override
    public void deleteContactos(long id) {
        userRepository.deleteById(id);
        log.info("Se borro usuario con el id " + id);
    }

    @Override
    public Contactos findByIdContactos(long id) {
        Optional<Contactos> optional = contactosRepository.findById(id);

        Contactos contactos = null;
        if (((Optional<?>) optional).isPresent()) {
            contactos = optional.get();
        } else {
            throw new RuntimeException(" Contacto no se encontro por id : " + id);
        }

        log.info("se veb rodos los contactos");
        return contactos;
    }

    @Override
    public List<Contactos> findAllContactos() {
        log.info("Se encontro lista de contactos con exito ");
        return contactosRepository.findAll();
    }
}

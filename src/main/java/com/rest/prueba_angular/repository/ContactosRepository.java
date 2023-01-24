package com.rest.prueba_angular.repository;

import com.rest.prueba_angular.model.Contactos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactosRepository extends JpaRepository<Contactos, Long> {
}

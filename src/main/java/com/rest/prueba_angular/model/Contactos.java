package com.rest.prueba_angular.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "contactos")
public class Contactos {

    @Id
    @Column(name = "idContacto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "fechanac", nullable = false)
    private LocalDate fechaNacimiento;

    private String celular;
    private String mail;

}

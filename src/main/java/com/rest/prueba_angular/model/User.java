package com.rest.prueba_angular.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "password" )
    private String password;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "email",  nullable = false)
    private String email;


    public User() {
    }

    public User(String password, String nombre, String apellidos, String email) {
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }
}

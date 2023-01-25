package com.rest.prueba_angular.security;

import lombok.Data;

/**
 * Esta clase define objetos tipo Usuario
 *
 * @author: Francisco granados
 * @version: undefine
 * Clase que recibira tanto correo electronico como contraseña
 */

@Data
public class AuthCredentials {

    private String email;
    private String contraseña;
}

package com.rest.prueba_angular.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    /**
     * @param http
     * @param authManager
     * @return
     * @throws Exception
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        return http
                .csrf().disable()
                //reglas de autorizacion toda solicitud debe ser autenticada
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                //ademas se habilita cualquier auntenticacion basica para que pida usuario y contraseña para despues ser ***desabilitado***
                .httpBasic()
                .and()
                //Configuracion y gestion de la sessiones
                .sessionManagement()
                //politica de sessiones sin estado
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }

    /**
     *
     * Configuracion de usuarios en memoria para pruebas
     * @return
     */
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
               // se cambia si no se quiere encriptado
                //.password("admin")
                .password(passwordEncoder().encode("admin"))
                .roles()
                .build());
        return manager;
    }


    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
            return http.getSharedObject(AuthenticationManagerBuilder.class)
                    // se manda llamar el UserDetailsService de arriba
                    .userDetailsService(userDetailsService())
                    .passwordEncoder(passwordEncoder())
                    .and()
                    .build();
    }


    /**
     * implementacion de password encoder para encryptar la contraseña
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

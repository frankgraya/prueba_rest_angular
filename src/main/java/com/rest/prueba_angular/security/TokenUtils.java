package com.rest.prueba_angular.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

/**
 * Clase configuradora de Token y tiempo de exitencia por 30 dias
 */
public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "eyJhbGciOiJIUzI1NiJ9";

    // 30 dias por 24 horas por 3600 segundos = 2,592,000
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(String nombre, String email){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate  = new Date(System.currentTimeMillis() *expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre",nombre);

        // Construccion del token
        return Jwts.builder()
                //quien lo recibe
                .setSubject(email)
                //tiempo de Expiracion
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
}

    /**
     * Metodo para la creacion de token que va a ser firmado para ser autenticado
     * @param token crea el token apartir de que ha sido autenticado
     * @return
     */
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){

       try {
           Claims claims = Jwts.parserBuilder()
                   .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();

           String email = claims.getSubject();

           return new UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());
       }catch (JwtException e){
            return null;
       }
    }

}
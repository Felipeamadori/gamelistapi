package com.example.gamelistapi.service;

import com.example.gamelistapi.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JWTokenService {
    @Value("${gamelist.jwt.expiration}")
    private String expiration;

    @Value("${gamelist.jwt.secret}")
    private String secret;
    public String makeToken(Authentication authentication) {

        Usuario logado = (Usuario) authentication.getPrincipal();
        Date today = new Date();
        Date dataExpiracao = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API Gameslist")
                .setSubject(String.valueOf(logado.getId_usuario()))
                .setIssuedAt(today)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getIdUsuario(String token) {
        return Integer.parseInt(Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody().getSubject());
    }
}

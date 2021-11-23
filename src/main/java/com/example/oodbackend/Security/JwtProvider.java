package com.example.oodbackend.Security;

import com.example.oodbackend.exceptions.SpringBootException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import com.example.oodbackend.entity.User;

import java.io.InputStream;
import java.security.*;
import java.time.Instant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.annotation.PostConstruct;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.sql.Date;
import java.time.Instant;

import static io.jsonwebtoken.Jwts.parser;
import static java.util.Date.from;

@Service
public class JwtProvider {

    private KeyStore keyStore;


    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new SpringBootException("Exception occurred while loading keystore", e);
        }

    }


    public String generateToken(Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey())
                .compact();
    }
    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringBootException("Exception occured while retrieving public key from keystore", e);
        }
    }

}

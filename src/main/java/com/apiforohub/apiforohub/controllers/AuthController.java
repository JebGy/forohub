package com.apiforohub.apiforohub.controllers;

import com.apiforohub.apiforohub.dto.DatosAuth;
import com.apiforohub.apiforohub.dto.DatosTokenJWT;
import com.apiforohub.apiforohub.dto.UsuarioDTO;
import com.apiforohub.apiforohub.models.Usuario;
import com.apiforohub.apiforohub.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAuth usuario) {
        var token = new UsernamePasswordAuthenticationToken(usuario.correoElectronico(), usuario.contrasena());
        var autentcicacion = authenticationManager.authenticate(token);

        var tokenJWT = tokenService.generarTokens((Usuario) autentcicacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}

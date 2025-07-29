package com.apiforohub.apiforohub.controllers;

import com.apiforohub.apiforohub.dto.UsuarioDTO;
import com.apiforohub.apiforohub.services.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/agregar")
    public void agregarNuevoUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.agregarUsuario(usuarioDTO);
    }
}

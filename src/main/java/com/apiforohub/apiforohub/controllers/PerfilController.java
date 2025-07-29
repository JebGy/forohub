package com.apiforohub.apiforohub.controllers;

import com.apiforohub.apiforohub.dto.CursoDTO;
import com.apiforohub.apiforohub.dto.PerfilDTO;
import com.apiforohub.apiforohub.services.CursoService;
import com.apiforohub.apiforohub.services.PerfilService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfiles")
@SecurityRequirement(name = "bearer-key")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping("/agregar")
    public void agregarperfil(@RequestBody PerfilDTO perfilDTO) {
        perfilService.agregarPerfil(perfilDTO);
    }
}

package com.apiforohub.apiforohub.controllers;

import com.apiforohub.apiforohub.dto.CursoDTO;
import com.apiforohub.apiforohub.services.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/agregar")
    public void agregarCurso(@RequestBody CursoDTO curso) {
        cursoService.crearNuevoCurso(curso);
    }

}

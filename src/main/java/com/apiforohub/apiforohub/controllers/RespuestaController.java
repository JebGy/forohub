package com.apiforohub.apiforohub.controllers;

import com.apiforohub.apiforohub.dto.RespuestaDTO;
import com.apiforohub.apiforohub.services.RespuestaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    private RespuestaService respuestaService;

    @PostMapping("/agregar")
    public void agregarNuevaRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
        respuestaService.agregarRespuesta(respuestaDTO);
    }
}

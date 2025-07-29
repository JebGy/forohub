package com.apiforohub.apiforohub.controllers;

import com.apiforohub.apiforohub.dto.TopicoDTO;
import com.apiforohub.apiforohub.models.Topico;
import com.apiforohub.apiforohub.services.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;


    @GetMapping
    public ResponseEntity<List<TopicoDTO>> obtenerTodosLosTopicos() {
        return topicoService.listarTopicos();
    }

    @PostMapping("/agregar")
    public ResponseEntity<TopicoDTO> agregarNuevoTopico(@RequestBody @Valid Topico topico) {
        try {
            topicoService.agregarTopico(topico);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> obtenerDetalleTopico(@PathVariable @Valid Integer id) {
        var topicoEncontrado = topicoService.obtenerDetalleTopico(id);
        return topicoEncontrado;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDTO> actualizarUnTopico(@PathVariable @Valid Integer id, @RequestBody @Valid TopicoDTO datosNuevos) {
        return topicoService.actualizarTopico(id, datosNuevos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TopicoDTO> eliminarUnTopico(@PathVariable @Valid Integer id) {
        return topicoService.eliminarUnTopico(id);
    }
}

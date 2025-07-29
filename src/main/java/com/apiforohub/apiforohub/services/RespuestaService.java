package com.apiforohub.apiforohub.services;

import com.apiforohub.apiforohub.dto.RespuestaDTO;
import com.apiforohub.apiforohub.models.Respuesta;
import com.apiforohub.apiforohub.repositories.RespuestaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Transactional
    public void agregarRespuesta(RespuestaDTO respuestaDTO){
        respuestaRepository.save(new Respuesta(
                respuestaDTO.mensaje(), respuestaDTO.fechaCreacion(),respuestaDTO.solucion()
        ));
    }
}

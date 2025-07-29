package com.apiforohub.apiforohub.dto;

import com.apiforohub.apiforohub.models.Curso;
import com.apiforohub.apiforohub.models.Respuesta;
import com.apiforohub.apiforohub.models.Usuario;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

public record TopicoDTO(Integer id, String titulo, String mensaje, Date fechaCreacion, Boolean status, UsuarioDTO autor,
                        CursoDTO curso,
                        List<RespuestaDTO> respuesta) {
}

package com.apiforohub.apiforohub.services;

import com.apiforohub.apiforohub.dto.CursoDTO;
import com.apiforohub.apiforohub.dto.RespuestaDTO;
import com.apiforohub.apiforohub.dto.TopicoDTO;
import com.apiforohub.apiforohub.dto.UsuarioDTO;
import com.apiforohub.apiforohub.models.Topico;
import com.apiforohub.apiforohub.repositories.TopicoRepository;
import com.apiforohub.apiforohub.utils.ErrorJPA;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    public void agregarTopico(Topico topico) {
        try {
            topicoRepository.save(topico);
        } catch (RuntimeException e) {
            throw new ErrorJPA("Error al guardar en la base de datos.");
        }
    }

    @Transactional
    public ResponseEntity<TopicoDTO> obtenerDetalleTopico(Integer id) {
        var topicoBuscado = topicoRepository.findById(id);
        return topicoBuscado.isPresent() ? new ResponseEntity<>(topicoAMostrar(topicoBuscado.get()), HttpStatus.FOUND) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Transactional
    public ResponseEntity<List<TopicoDTO>> listarTopicos() {
        var topicosListados = topicoRepository.findAll();
        return topicosListados.size() > 0 ? new ResponseEntity<>(topicosListados.stream().map(t -> topicoAMostrar(t)).collect(Collectors.toList()), HttpStatus.FOUND) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Transactional
    public ResponseEntity<TopicoDTO> actualizarTopico(Integer id, TopicoDTO datosActualizados) {
        return topicoRepository.findById(id).map(topico -> {
            Optional.ofNullable(datosActualizados.titulo()).ifPresent(topico::setTitulo);
            Optional.ofNullable(datosActualizados.mensaje()).ifPresent(topico::setMensaje);
            Optional.ofNullable(datosActualizados.status()).ifPresent(topico::setStatus);
            topicoRepository.save(topico);
            return new ResponseEntity<>(topicoAMostrar(topico), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public TopicoDTO topicoAMostrar(Topico topico) {
        TopicoDTO topicoTransformado = new TopicoDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), new UsuarioDTO(topico.getAutor().getNombre(), topico.getAutor().getCorreoElectronico()), new CursoDTO(topico.getCurso().getNombre(), topico.getCurso().getCategoria()), topico.getRespuesta().stream().map(respuesta -> new RespuestaDTO(respuesta.getMensaje(), respuesta.getFechaCreacion(), respuesta.getSolucion())).collect(Collectors.toList()));
        return topicoTransformado;
    }

    @Transactional
    public ResponseEntity<TopicoDTO> eliminarUnTopico(@Valid Integer id) {
        return topicoRepository.findById(id).map(topico -> {
            topicoRepository.delete(topico);
            return new ResponseEntity<>(topicoAMostrar(topico), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

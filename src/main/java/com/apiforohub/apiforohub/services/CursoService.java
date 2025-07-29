package com.apiforohub.apiforohub.services;

import com.apiforohub.apiforohub.dto.CursoDTO;
import com.apiforohub.apiforohub.models.Curso;
import com.apiforohub.apiforohub.repositories.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public void crearNuevoCurso(CursoDTO curso) {
        cursoRepository.save(new Curso( curso.nombre(), curso.categoria()));
    }
}

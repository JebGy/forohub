package com.apiforohub.apiforohub.services;

import com.apiforohub.apiforohub.dto.PerfilDTO;
import com.apiforohub.apiforohub.models.Perfil;
import com.apiforohub.apiforohub.repositories.PerfilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    @Transactional
    public void agregarPerfil(PerfilDTO perfil){
        perfilRepository.save(new Perfil(
                perfil.nombre()
        ));
    }
}

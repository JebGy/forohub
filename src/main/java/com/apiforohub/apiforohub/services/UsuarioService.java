package com.apiforohub.apiforohub.services;

import com.apiforohub.apiforohub.dto.UsuarioDTO;
import com.apiforohub.apiforohub.models.Usuario;
import com.apiforohub.apiforohub.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void agregarUsuario(UsuarioDTO ususario) {
        usuarioRepository.save(new Usuario(ususario.nombre(), ususario.correoElectronico(),""));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByCorreoElectronico(username);
    }
}

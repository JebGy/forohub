package com.apiforohub.apiforohub.repositories;

import com.apiforohub.apiforohub.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Integer> {
}

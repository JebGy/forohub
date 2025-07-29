package com.apiforohub.apiforohub.repositories;

import com.apiforohub.apiforohub.models.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico,Integer> {
}

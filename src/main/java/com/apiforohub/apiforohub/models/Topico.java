package com.apiforohub.apiforohub.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    private Date fechaCreacion;
    private Boolean status;

    @ManyToOne()
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Usuario autor;
    @ManyToOne()
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuesta;

    public Topico() {
    }

    public Topico(String titulo, String mensaje, Date fechaCreacion, Boolean status) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
    }
}

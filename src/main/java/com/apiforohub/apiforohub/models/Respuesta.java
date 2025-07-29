package com.apiforohub.apiforohub.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mensaje;
    private Date fechaCreacion;
    private String solucion;
    @ManyToOne()
    private Usuario autor;
    @ManyToOne()
    private Topico topico;

    public Respuesta() {
    }

    public Respuesta(String mensaje, Date fechaCreacion, String solucion) {
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.solucion = solucion;
    }
}

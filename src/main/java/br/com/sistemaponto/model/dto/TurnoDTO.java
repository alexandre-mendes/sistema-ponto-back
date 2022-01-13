package br.com.sistemaponto.model.dto;

import javax.persistence.Column;
import java.io.Serializable;

public class TurnoDTO implements Serializable {

    private Long id;
    private String titulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

package br.com.sistemaponto.model.dto;

import java.io.Serializable;

public class FuncionarioDTO implements Serializable {

    private Long id;
    private String nomeFuncionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

}

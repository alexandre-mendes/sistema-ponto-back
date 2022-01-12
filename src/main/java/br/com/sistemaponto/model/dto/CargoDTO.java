package br.com.sistemaponto.model.dto;

import java.io.Serializable;

public class CargoDTO implements Serializable {

    private Long id;
    private String descricaoCargo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

}

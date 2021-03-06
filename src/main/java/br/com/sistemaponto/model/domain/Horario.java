package br.com.sistemaponto.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "horario")
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dataHora")
    private LocalDate dataHora;

    @Column(name = "aprovado")
    private Boolean aprovado;

    @Column(name = "aprovador")
    private UsuarioDTO aprovador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public UsuarioDTO getAprovador() {
        return aprovador;
    }

    public void setAprovador(UsuarioDTO aprovador) {
        this.aprovador = aprovador;
    }
}

package br.com.sistemaponto.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome-funcionario")
    private String nomeFuncionario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cargo cargo;

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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
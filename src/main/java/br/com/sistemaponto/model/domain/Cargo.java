package br.com.sistemaponto.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao_cargo")
    private String descricaoCargo;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionario;

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

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }
}

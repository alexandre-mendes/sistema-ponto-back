package br.com.sistemaponto.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "empresa")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}

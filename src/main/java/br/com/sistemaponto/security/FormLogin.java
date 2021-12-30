package br.com.sistemaponto.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.io.Serializable;

public class FormLogin implements Serializable {

    private String login;
    private String senha;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(login, senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

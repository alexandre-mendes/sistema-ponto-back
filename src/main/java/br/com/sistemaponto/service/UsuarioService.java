package br.com.sistemaponto.service;

import br.com.sistemaponto.exception.EntityNotFoundException;
import br.com.sistemaponto.model.domain.Usuario;
import br.com.sistemaponto.model.dto.UsuarioDTO;
import br.com.sistemaponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criar(final Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario obter(final Long id) {
       return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));
    }

    public Usuario atualizar(final Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public void deletar(final Long id) {
        usuarioRepository.deleteById(id);
    }
}

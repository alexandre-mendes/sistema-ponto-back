package br.com.sistemaponto.service;

import br.com.sistemaponto.exception.EntityNotFoundException;
import br.com.sistemaponto.model.domain.Funcionario;
import br.com.sistemaponto.model.domain.Usuario;
import br.com.sistemaponto.model.dto.UsuarioDTO;
import br.com.sistemaponto.repository.FuncionarioRepository;
import br.com.sistemaponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario criar(final Funcionario funcionario) {
        funcionario.setNomeFuncionario(funcionario.getNomeFuncionario());
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario obter(final Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado."));
    }

    public Funcionario atualizar(final Funcionario funcionario) {
        funcionario.setNomeFuncionario(funcionario.getNomeFuncionario());
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(final Long id) {
        funcionarioRepository.deleteById(id);
    }
}

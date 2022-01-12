package br.com.sistemaponto.service;

import br.com.sistemaponto.exception.EntityNotFoundException;
import br.com.sistemaponto.model.domain.Funcionario;
import br.com.sistemaponto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario criar(final Funcionario funcionario) {
        funcionario.setNome(funcionario.getNome());
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario obter(final Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado."));
    }

    public Funcionario atualizar(final Funcionario funcionario) {
        funcionario.setNome(funcionario.getNome());
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(final Long id) {
        funcionarioRepository.deleteById(id);
    }
}

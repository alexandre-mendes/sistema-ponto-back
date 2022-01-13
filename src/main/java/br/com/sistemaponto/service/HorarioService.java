package br.com.sistemaponto.service;

import br.com.sistemaponto.exception.EntityNotFoundException;
import br.com.sistemaponto.model.domain.Funcionario;
import br.com.sistemaponto.model.domain.Horario;
import br.com.sistemaponto.repository.FuncionarioRepository;
import br.com.sistemaponto.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public Horario criar(final Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario obter(final Long id) {
        return horarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Horario não encontrado."));
    }

    public Horario atualizar(final Horario horario) {
        return horarioRepository.save(horario);
    }

    public void deletar(final Long id) {
        horarioRepository.deleteById(id);
    }
}

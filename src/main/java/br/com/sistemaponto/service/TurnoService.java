package br.com.sistemaponto.service;

import br.com.sistemaponto.exception.EntityNotFoundException;
import br.com.sistemaponto.model.domain.Cargo;
import br.com.sistemaponto.model.domain.Turno;
import br.com.sistemaponto.repository.CargoRepository;
import br.com.sistemaponto.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public Turno criar(final Turno turno) {
        return turnoRepository.save(turno);
    }

    public Turno obter(final Long id) {
        return turnoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turno não encontrado."));
    }

    public Turno atualizar(final Turno turno) {
        return turnoRepository.save(turno);
    }

    public void deletar(final Long id) {
        turnoRepository.deleteById(id);
    }
}

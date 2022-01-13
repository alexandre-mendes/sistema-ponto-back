package br.com.sistemaponto.repository;

import br.com.sistemaponto.model.domain.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
}

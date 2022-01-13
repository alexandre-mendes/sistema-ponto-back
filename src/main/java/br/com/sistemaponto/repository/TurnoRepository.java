package br.com.sistemaponto.repository;

import br.com.sistemaponto.model.domain.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
}

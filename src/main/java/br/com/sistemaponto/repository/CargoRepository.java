package br.com.sistemaponto.repository;

import br.com.sistemaponto.model.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}

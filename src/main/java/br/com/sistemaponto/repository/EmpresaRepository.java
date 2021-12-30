package br.com.sistemaponto.repository;

import br.com.sistemaponto.model.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}

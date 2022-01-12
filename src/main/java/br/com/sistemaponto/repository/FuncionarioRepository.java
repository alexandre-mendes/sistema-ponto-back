package br.com.sistemaponto.repository;

import br.com.sistemaponto.model.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}

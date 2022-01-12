package br.com.sistemaponto.service;

import br.com.sistemaponto.exception.EntityNotFoundException;
import br.com.sistemaponto.model.domain.Cargo;
import br.com.sistemaponto.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

        @Autowired
        private CargoRepository cargoRepository;

        public Cargo criar(final Cargo cargo) {
            return cargoRepository.save(cargo);
        }

        public Cargo obter(final Long id) {
            return cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado."));
        }

        public Cargo atualizar(final Cargo cargo) {
            return cargoRepository.save(cargo);
        }

        public void deletar(final Long id) {
            cargoRepository.deleteById(id);
        }
}

package br.com.sistemaponto.controller;

import br.com.sistemaponto.model.dto.EmpresaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @PostMapping
    public void criar(final EmpresaDTO dto) {}

    @GetMapping
    public void obter() {}

    @PutMapping
    public void atualizar() {}

    @DeleteMapping
    public void deletar() {}
}

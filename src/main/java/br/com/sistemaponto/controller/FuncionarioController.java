package br.com.sistemaponto.controller;

import br.com.sistemaponto.model.domain.Funcionario;
import br.com.sistemaponto.model.domain.Usuario;
import br.com.sistemaponto.model.dto.FuncionarioDTO;
import br.com.sistemaponto.model.dto.UsuarioDTO;
import br.com.sistemaponto.service.FuncionarioService;
import br.com.sistemaponto.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/funcionarios")
@Api(value = "Funcionario Controller")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cria um novo funcionario", authorizations = {@Authorization(value = "Bearer")})
    public FuncionarioDTO criar(@RequestBody final FuncionarioDTO dto) {
        final Funcionario funcionario = modelMapper.map(dto, Funcionario.class);
        final Funcionario funcionarioSalvo = funcionarioService.criar(funcionario);
        return modelMapper.map(funcionarioSalvo, FuncionarioDTO.class);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Obtem funcionario por ID", authorizations = {@Authorization(value = "Bearer")})
    public FuncionarioDTO obter(@PathVariable final Long id) {
        final Funcionario funcionario = funcionarioService.obter(id);
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza funcionario", authorizations = {@Authorization(value = "Bearer")})
    public FuncionarioDTO atualizar(@RequestBody final FuncionarioDTO dto) {
        final Funcionario funcionario = modelMapper.map(dto, Funcionario.class);
        final Funcionario funcionarioAtualizado = funcionarioService.atualizar(funcionario);
        return modelMapper.map(funcionarioAtualizado, FuncionarioDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta funcionario por ID", authorizations = {@Authorization(value = "Bearer")})
    public void deletar(@PathVariable final Long id) {
        funcionarioService.deletar(id);
    }
}

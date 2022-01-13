package br.com.sistemaponto.controller;

import br.com.sistemaponto.model.domain.Cargo;
import br.com.sistemaponto.model.domain.Horario;
import br.com.sistemaponto.model.domain.Usuario;
import br.com.sistemaponto.model.dto.CargoDTO;
import br.com.sistemaponto.model.dto.HorarioDTO;
import br.com.sistemaponto.model.dto.UsuarioDTO;
import br.com.sistemaponto.service.CargoService;
import br.com.sistemaponto.service.HorarioService;
import br.com.sistemaponto.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/horario")
@Api(value = "Horario Controller")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cria um novo horario", authorizations = {@Authorization(value = "Bearer")})
    public HorarioDTO criar(@RequestBody final HorarioDTO dto) {
        final Horario horario = modelMapper.map(dto, Horario.class);
        final Horario horarioSalvo = horarioService.criar(horario);
        return modelMapper.map(horarioSalvo, HorarioDTO.class);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Obtem horario por ID", authorizations = {@Authorization(value = "Bearer")})
    public HorarioDTO obter(@PathVariable final Long id) {
        final Horario horario = horarioService.obter(id);
        return modelMapper.map(horario, HorarioDTO.class);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza horario", authorizations = {@Authorization(value = "Bearer")})
    public HorarioDTO atualizar(@RequestBody final HorarioDTO dto) {
        final Horario horario = modelMapper.map(dto, Horario.class);
        final Horario horarioAtualizado = horarioService.atualizar(horario);
        return modelMapper.map(horarioService, HorarioDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta horario por ID", authorizations = {@Authorization(value = "Bearer")})
    public void deletar(@PathVariable final Long id) {
        horarioService.deletar(id);
    }
}

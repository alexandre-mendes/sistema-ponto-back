package br.com.sistemaponto.controller;

import br.com.sistemaponto.model.domain.Cargo;
import br.com.sistemaponto.model.domain.Turno;
import br.com.sistemaponto.model.domain.Usuario;
import br.com.sistemaponto.model.dto.CargoDTO;
import br.com.sistemaponto.model.dto.TurnoDTO;
import br.com.sistemaponto.model.dto.UsuarioDTO;
import br.com.sistemaponto.service.CargoService;
import br.com.sistemaponto.service.TurnoService;
import br.com.sistemaponto.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/turno")
@Api(value = "Turno Controller")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cria um novo turno", authorizations = {@Authorization(value = "Bearer")})
    public TurnoDTO criar(@RequestBody final TurnoDTO dto) {
        final Turno turno = modelMapper.map(dto, Turno.class);
        final Turno turnoSalvo = turnoService.criar(turno);
        return modelMapper.map(turnoSalvo, TurnoDTO.class);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Obtem turno por ID", authorizations = {@Authorization(value = "Bearer")})
    public TurnoDTO obter(@PathVariable final Long id) {
        final Turno turno = turnoService.obter(id);
        return modelMapper.map(turno, TurnoDTO.class);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza turno", authorizations = {@Authorization(value = "Bearer")})
    public TurnoDTO atualizar(@RequestBody final TurnoDTO dto) {
        final Turno turno = modelMapper.map(dto, Turno.class);
        final Turno turnoAtualizado = turnoService.atualizar(turno);
        return modelMapper.map(turnoService, TurnoDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta turno por ID", authorizations = {@Authorization(value = "Bearer")})
    public void deletar(@PathVariable final Long id) {
        turnoService.deletar(id);
    }
}

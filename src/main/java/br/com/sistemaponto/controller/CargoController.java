package br.com.sistemaponto.controller;

import br.com.sistemaponto.model.domain.Cargo;
import br.com.sistemaponto.model.domain.Usuario;
import br.com.sistemaponto.model.dto.CargoDTO;
import br.com.sistemaponto.model.dto.UsuarioDTO;
import br.com.sistemaponto.service.CargoService;
import br.com.sistemaponto.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios")
@Api(value = "Cargo Controller")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cria um novo usuário", authorizations = {@Authorization(value = "Bearer")})
    public CargoDTO criar(@RequestBody final CargoDTO dto) {
        final Cargo cargo = modelMapper.map(dto, Cargo.class);
        final Cargo cargoSalvo = cargoService.criar(cargo);
        return modelMapper.map(cargoSalvo, CargoDTO.class);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Obtem usuário por ID", authorizations = {@Authorization(value = "Bearer")})
    public CargoDTO obter(@PathVariable final Long id) {
        final Cargo cargo = cargoService.obter(id);
        return modelMapper.map(cargo, CargoDTO.class);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza usuário", authorizations = {@Authorization(value = "Bearer")})
    public CargoDTO atualizar(@RequestBody final CargoDTO dto) {
        final Cargo cargo = modelMapper.map(dto, Cargo.class);
        final Cargo cargoAtualizado = cargoService.atualizar(cargo);
        return modelMapper.map(cargoService, CargoDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta usuário por ID", authorizations = {@Authorization(value = "Bearer")})
    public void deletar(@PathVariable final Long id) {
        cargoService.deletar(id);
    }
}

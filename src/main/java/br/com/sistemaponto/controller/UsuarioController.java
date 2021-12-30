package br.com.sistemaponto.controller;

import br.com.sistemaponto.model.domain.Usuario;
import br.com.sistemaponto.model.dto.UsuarioDTO;
import br.com.sistemaponto.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios")
@Api(value = "Usuarío Controller")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cria um novo usuário", authorizations = {@Authorization(value = "Bearer")})
    public UsuarioDTO criar(@RequestBody final UsuarioDTO dto) {
        final Usuario usuario = modelMapper.map(dto, Usuario.class);
        final Usuario usuarioSalvo = usuarioService.criar(usuario);
        return modelMapper.map(usuarioSalvo, UsuarioDTO.class);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Obtem usuário por ID", authorizations = {@Authorization(value = "Bearer")})
    public UsuarioDTO obter(@PathVariable final Long id) {
        final Usuario usuario = usuarioService.obter(id);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza usuário", authorizations = {@Authorization(value = "Bearer")})
    public UsuarioDTO atualizar(@RequestBody final UsuarioDTO dto) {
        final Usuario usuario = modelMapper.map(dto, Usuario.class);
        final Usuario usuarioAtualizado = usuarioService.atualizar(usuario);
        return modelMapper.map(usuarioAtualizado, UsuarioDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta usuário por ID", authorizations = {@Authorization(value = "Bearer")})
    public void deletar(@PathVariable final Long id) {
        usuarioService.deletar(id);
    }
}

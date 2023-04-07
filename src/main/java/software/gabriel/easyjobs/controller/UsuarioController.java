/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.easyjobs.dto.AtivacaoDTO;
import software.gabriel.easyjobs.dto.UsuarioDTO;
import software.gabriel.easyjobs.service.UsuarioService;

/**
 *
 * @author gabriel
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody UsuarioDTO usuarioDTO) {        
        usuarioService.cadastrar(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/ativacao")
    public ResponseEntity<Void> ativar(@Valid @RequestBody AtivacaoDTO ativacaoDTO) {
        usuarioService.ativar(ativacaoDTO);
        return ResponseEntity.ok().build();
    }

}

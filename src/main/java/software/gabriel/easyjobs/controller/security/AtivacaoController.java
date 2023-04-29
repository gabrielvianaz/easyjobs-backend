/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.controller.security;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.easyjobs.dto.security.AtivacaoDTO;
import software.gabriel.easyjobs.dto.security.UsuarioDTO;
import software.gabriel.easyjobs.service.security.AtivacaoService;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/ativacao")
public class AtivacaoController {

    @Autowired
    AtivacaoService ativacaoService;

    @PostMapping
    public ResponseEntity<Void> ativar(@Valid @RequestBody AtivacaoDTO ativacaoDTO) {
        ativacaoService.ativar(ativacaoDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/renovar")
    public ResponseEntity<Void> renovar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        ativacaoService.renovar(usuarioDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

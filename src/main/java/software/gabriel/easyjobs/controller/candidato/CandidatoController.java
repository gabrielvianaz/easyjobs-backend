/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.controller.candidato;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.easyjobs.controller.base.AbstractController;
import software.gabriel.easyjobs.dto.candidato.CandidatoDTO;
import software.gabriel.easyjobs.service.candidato.CandidatoService;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/candidatos")
public class CandidatoController
        extends AbstractController<CandidatoService> {

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody CandidatoDTO candidatoDTO) {
        service.cadastrar(candidatoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

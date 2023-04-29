/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.controller.curriculo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.easyjobs.controller.base.AbstractController;
import software.gabriel.easyjobs.dto.curriculo.ResumoDTO;
import software.gabriel.easyjobs.service.curriculo.ResumoService;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/curriculo/resumo")
public class ResumoController
        extends AbstractController<ResumoService> {

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody ResumoDTO resumoDTO) {
        service.cadastrar(resumoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> alterar(@Valid @RequestBody ResumoDTO resumoDTO) {
        service.alterar(resumoDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

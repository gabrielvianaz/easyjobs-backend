/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.controller.curriculo;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.easyjobs.controller.base.AbstractController;
import software.gabriel.easyjobs.dto.curriculo.CertificadoDTO;
import software.gabriel.easyjobs.service.curriculo.CertificadoService;

/**
 *
 * @author gabriel
 */
@Validated
@RestController
@RequestMapping("/curriculo/certificados")
public class CertificadoController
        extends AbstractController<CertificadoService> {

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody List<@Valid CertificadoDTO> certificadosDTO) {
        service.cadastrar(certificadosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterar(@PathVariable Long id, @RequestBody @Valid CertificadoDTO certificadoDTO) {
        service.alterar(id, certificadoDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

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
import software.gabriel.easyjobs.dto.curriculo.IdiomaDTO;
import software.gabriel.easyjobs.service.curriculo.IdiomaService;

/**
 *
 * @author gabriel
 */
@Validated
@RestController
@RequestMapping("/curriculo/idiomas")
public class IdiomaController
        extends AbstractController<IdiomaService> {

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody List<@Valid IdiomaDTO> idiomasDTO) {
        service.cadastrar(idiomasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterar(@PathVariable Long id, @RequestBody @Valid IdiomaDTO idiomaDTO) {
        service.alterar(id, idiomaDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

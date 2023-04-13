/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model;

import java.time.LocalDate;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.enums.GeneroCandidato;

/**
 *
 * @author gabriel
 */
public interface CandidatoModel
        extends BaseModel {

    String getNome();

    String getCpf();

    LocalDate getDataNascimento();

    GeneroCandidato getGenero();

    String getCidade();

    String getEstado();

    Usuario getUsuario();

}

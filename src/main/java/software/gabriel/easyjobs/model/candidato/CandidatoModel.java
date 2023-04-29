/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model.candidato;

import java.time.LocalDate;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.entity.security.Usuario;
import software.gabriel.easyjobs.enums.candidato.GeneroCandidato;
import software.gabriel.easyjobs.model.base.EntityModel;

/**
 *
 * @author gabriel
 */
public interface CandidatoModel
        extends EntityModel {

    String getNome();

    String getCpf();

    LocalDate getDataNascimento();

    GeneroCandidato getGenero();

    String getCidade();

    String getEstado();

    Usuario getUsuario();
    
    Curriculo getCurriculo();

}

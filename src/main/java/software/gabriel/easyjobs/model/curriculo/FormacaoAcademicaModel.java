/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model.curriculo;

import software.gabriel.easyjobs.model.base.curriculo.CampoCurriculoModel;
import software.gabriel.easyjobs.enums.curriculo.GrauFormacao;
import software.gabriel.easyjobs.enums.curriculo.NivelFormacao;
import software.gabriel.easyjobs.enums.curriculo.SituacaoFormacao;

/**
 *
 * @author gabriel
 */
public interface FormacaoAcademicaModel
        extends CampoCurriculoModel {

    String getCurso();

    String getInstituicao();

    NivelFormacao getNivel();

    GrauFormacao getGrau();

    SituacaoFormacao getSituacao();

    Integer getMesInicio();

    Integer getAnoInicio();

    Integer getMesConclusao();

    Integer getAnoConclusao();

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model.curriculo;

import java.util.List;
import software.gabriel.easyjobs.entity.candidato.Candidato;
import software.gabriel.easyjobs.entity.curriculo.Certificado;
import software.gabriel.easyjobs.entity.curriculo.ExperienciaProfissional;
import software.gabriel.easyjobs.entity.curriculo.FormacaoAcademica;
import software.gabriel.easyjobs.entity.curriculo.Idioma;
import software.gabriel.easyjobs.entity.curriculo.Resumo;
import software.gabriel.easyjobs.model.base.EntityModel;

/**
 *
 * @author gabriel
 */
public interface CurriculoModel
        extends EntityModel {
    
    Candidato getCandidato();

    Resumo getResumo();
    
    List<ExperienciaProfissional> getExperienciasProfissionais();
    
    List<FormacaoAcademica> getFormacoesAcademicas();
    
    List<Certificado> getCertificados();
    
    List<Idioma> getIdiomas();

}

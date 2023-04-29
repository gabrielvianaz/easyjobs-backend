/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.curriculo;

import java.util.List;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.curriculo.FormacaoAcademicaDTO;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.entity.curriculo.FormacaoAcademica;
import software.gabriel.easyjobs.repository.curriculo.FormacaoAcademicaRepository;
import software.gabriel.easyjobs.service.base.curriculo.AbstractCampoCurriculoManyToOneService;

/**
 *
 * @author gabriel
 */
@Service
public class FormacaoAcademicaService
        extends AbstractCampoCurriculoManyToOneService<FormacaoAcademica, FormacaoAcademicaDTO, FormacaoAcademicaRepository> {

    public FormacaoAcademicaService() {
        super(FormacaoAcademica.class);
    }

    public void cadastrar(List<FormacaoAcademicaDTO> formacoesAcademicasDTO) {
        Curriculo curriculo = getCurriculoCandidatoAutenticado();
        cadastrar(formacoesAcademicasDTO, curriculo, curriculo.getFormacoesAcademicas());
    }

    protected FormacaoAcademica aplicarDTO(FormacaoAcademica formacaoAcademica, FormacaoAcademicaDTO formacaoAcademicaDTO) {
        formacaoAcademica.setCurso(formacaoAcademicaDTO.getCurso());
        formacaoAcademica.setInstituicao(formacaoAcademicaDTO.getInstituicao());
        formacaoAcademica.setNivel(formacaoAcademicaDTO.getNivel());
        formacaoAcademica.setGrau(formacaoAcademicaDTO.getGrau());
        formacaoAcademica.setSituacao(formacaoAcademicaDTO.getSituacao());
        formacaoAcademica.setMesInicio(formacaoAcademicaDTO.getMesInicio());
        formacaoAcademica.setAnoInicio(formacaoAcademicaDTO.getAnoInicio());
        formacaoAcademica.setMesConclusao(formacaoAcademicaDTO.getMesConclusao());
        formacaoAcademica.setAnoConclusao(formacaoAcademicaDTO.getAnoConclusao());
        return formacaoAcademica;
    }

}

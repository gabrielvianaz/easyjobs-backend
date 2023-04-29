/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper.curriculo;

import org.mapstruct.Mapper;
import software.gabriel.easyjobs.dto.curriculo.CertificadoDTO;
import software.gabriel.easyjobs.dto.curriculo.ExperienciaProfissionalDTO;
import software.gabriel.easyjobs.dto.curriculo.FormacaoAcademicaDTO;
import software.gabriel.easyjobs.dto.curriculo.IdiomaDTO;
import software.gabriel.easyjobs.dto.curriculo.ResumoDTO;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculo;
import software.gabriel.easyjobs.entity.curriculo.Certificado;
import software.gabriel.easyjobs.entity.curriculo.ExperienciaProfissional;
import software.gabriel.easyjobs.entity.curriculo.FormacaoAcademica;
import software.gabriel.easyjobs.entity.curriculo.Idioma;
import software.gabriel.easyjobs.entity.curriculo.Resumo;
import software.gabriel.easyjobs.mapper.base.DefaultMapper;

/**
 *
 * @author gabriel
 */
@Mapper(config = DefaultMapper.class)
public interface CampoCurriculoMapper
        extends DefaultMapper<AbstractCampoCurriculo, CampoCurriculoDTO<AbstractCampoCurriculo>> {

    @Override
    default CampoCurriculoDTO toDTO(AbstractCampoCurriculo entity) {
        if (entity instanceof Resumo resumo) {
            return toResumoDTO(resumo);
        } else if (entity instanceof ExperienciaProfissional experienciaProfissional) {
            return toExperienciaProfissionalDTO(experienciaProfissional);
        } else if (entity instanceof FormacaoAcademica formacaoAcademica) {
            return toFormacaoAcademicaDTO(formacaoAcademica);
        } else if (entity instanceof Certificado certificado) {
            return toCertificadoDTO(certificado);
        } else if (entity instanceof Idioma idioma) {
            return toIdiomaDTO(idioma);
        } else {
            return null;
        }
    }

    @Override
    default AbstractCampoCurriculo toEntity(CampoCurriculoDTO dto) {
        if (dto instanceof ResumoDTO resumoDTO) {
            return toResumoEntity(resumoDTO);
        } else if (dto instanceof ExperienciaProfissionalDTO experienciaProfissionalDTO) {
            return toExperienciaProfissionalEntity(experienciaProfissionalDTO);
        } else if (dto instanceof FormacaoAcademicaDTO formacaoAcademicaDTO) {
            return toFormacaoAcademicaEntity(formacaoAcademicaDTO);
        } else if (dto instanceof CertificadoDTO certificadoDTO) {
            return toCertificadoEntity(certificadoDTO);
        } else if (dto instanceof IdiomaDTO idiomaDTO) {
            return toIdiomaEntity(idiomaDTO);
        } else {
            return null;
        }
    }

    ResumoDTO toResumoDTO(Resumo entity);

    ExperienciaProfissionalDTO toExperienciaProfissionalDTO(ExperienciaProfissional entity);

    FormacaoAcademicaDTO toFormacaoAcademicaDTO(FormacaoAcademica entity);

    CertificadoDTO toCertificadoDTO(Certificado entity);

    IdiomaDTO toIdiomaDTO(Idioma entity);
    
    Resumo toResumoEntity(ResumoDTO dto);
    
    ExperienciaProfissional toExperienciaProfissionalEntity(ExperienciaProfissionalDTO dto);
    
    FormacaoAcademica toFormacaoAcademicaEntity(FormacaoAcademicaDTO dto);
    
    Certificado toCertificadoEntity(CertificadoDTO dto);
    
    Idioma toIdiomaEntity(IdiomaDTO dto);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.curriculo;

import software.gabriel.easyjobs.dto.candidato.CandidatoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import software.gabriel.easyjobs.dto.base.AbstractDTO;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;

/**
 *
 * @author gabriel
 */
public class CurriculoDTO
        extends AbstractDTO<Curriculo> {

    @JsonIgnoreProperties({"curriculo"})
    private CandidatoDTO candidato;

    private ResumoDTO resumo;

    private List<ExperienciaProfissionalDTO> experienciasProfissionais = new ArrayList<>();

    private List<FormacaoAcademicaDTO> formacoesAcademicas = new ArrayList<>();

    private List<CertificadoDTO> certificados = new ArrayList<>();

    private List<IdiomaDTO> idiomas = new ArrayList<>();

    public CandidatoDTO getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoDTO candidato) {
        this.candidato = candidato;
    }

    public ResumoDTO getResumo() {
        return resumo;
    }

    public void setResumo(ResumoDTO resumo) {
        this.resumo = resumo;
    }

    public List<ExperienciaProfissionalDTO> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void setExperienciasProfissionais(List<ExperienciaProfissionalDTO> experienciasProfissionais) {
        this.experienciasProfissionais = experienciasProfissionais;
    }

    public List<FormacaoAcademicaDTO> getFormacoesAcademicas() {
        return formacoesAcademicas;
    }

    public void setFormacoesAcademicas(List<FormacaoAcademicaDTO> formacoesAcademicas) {
        this.formacoesAcademicas = formacoesAcademicas;
    }

    public List<CertificadoDTO> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<CertificadoDTO> certificados) {
        this.certificados = certificados;
    }

    public List<IdiomaDTO> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<IdiomaDTO> idiomas) {
        this.idiomas = idiomas;
    }

}

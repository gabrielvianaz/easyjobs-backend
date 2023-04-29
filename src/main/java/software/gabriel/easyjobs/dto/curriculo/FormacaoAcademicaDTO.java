/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.curriculo;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.curriculo.FormacaoAcademica;
import software.gabriel.easyjobs.enums.curriculo.GrauFormacao;
import software.gabriel.easyjobs.enums.curriculo.NivelFormacao;
import software.gabriel.easyjobs.enums.curriculo.SituacaoFormacao;

/**
 *
 * @author gabriel
 */
public class FormacaoAcademicaDTO
        extends CampoCurriculoDTO<FormacaoAcademica> {

    private String curso;

    @NotBlank(message = "O campo 'instituicao' deve ser preenchido!")
    @Column(nullable = false)
    private String instituicao;

    @NotNull(message = "O campo 'nivel' deve ser preenchido!")
    private NivelFormacao nivel;

    private GrauFormacao grau;

    @NotNull(message = "O campo 'situacao' deve ser preenchido!")
    private SituacaoFormacao situacao;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesInicio' deve estar entre 1 e 12!")
    @NotNull(message = "O campo 'mesInicio' deve ser preenchido!")
    private Integer mesInicio;

    @Size(min = 4, max = 4, message = "O campo 'anoInicio' deve possuir 4 dígitos!")
    @NotNull(message = "O campo 'anoInicio' deve ser preenchido!")
    private Integer anoInicio;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesConclusao' deve estar entre 1 e 12!")
    @NotNull(message = "O campo 'mesConclusao' deve ser preenchido!")
    private Integer mesConclusao;

    @Size(min = 4, max = 4, message = "O campo 'anoConclusao' deve possuir 4 dígitos!")
    @NotNull(message = "O campo 'anoConclusao' deve ser preenchido!")
    private Integer anoConclusao;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public NivelFormacao getNivel() {
        return nivel;
    }

    public void setNivel(NivelFormacao nivel) {
        this.nivel = nivel;
    }

    public GrauFormacao getGrau() {
        return grau;
    }

    public void setGrau(GrauFormacao grau) {
        this.grau = grau;
    }

    public SituacaoFormacao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoFormacao situacao) {
        this.situacao = situacao;
    }

    public Integer getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(Integer mesInicio) {
        this.mesInicio = mesInicio;
    }

    public Integer getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(Integer anoInicio) {
        this.anoInicio = anoInicio;
    }

    public Integer getMesConclusao() {
        return mesConclusao;
    }

    public void setMesConclusao(Integer mesConclusao) {
        this.mesConclusao = mesConclusao;
    }

    public Integer getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(Integer anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

}

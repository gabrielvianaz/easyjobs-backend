/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity.curriculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;
import org.hibernate.validator.constraints.Range;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculoManyToOne;
import software.gabriel.easyjobs.enums.curriculo.GrauFormacao;
import software.gabriel.easyjobs.enums.curriculo.NivelFormacao;
import software.gabriel.easyjobs.enums.curriculo.SituacaoFormacao;
import software.gabriel.easyjobs.model.curriculo.FormacaoAcademicaModel;
import software.gabriel.easyjobs.model.base.NamedEntityModel;

/**
 *
 * @author gabriel
 */
@Entity
public class FormacaoAcademica
        extends AbstractCampoCurriculoManyToOne
        implements FormacaoAcademicaModel, NamedEntityModel {

    private String curso;

    @NotBlank(message = "O campo 'instituicao' deve ser preenchido!")
    @Column(nullable = false)
    private String instituicao;

    @NotNull(message = "O campo 'nivel' deve ser preenchido!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelFormacao nivel;

    @Enumerated(EnumType.STRING)
    private GrauFormacao grau;

    @NotNull(message = "O campo 'situacao' deve ser preenchido!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoFormacao situacao;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesInicio' deve estar entre 1 e 12!")
    @NotNull(message = "O campo 'mesInicio' deve ser preenchido!")
    @Column(nullable = false)
    private Integer mesInicio;

    @Size(min = 4, max = 4, message = "O campo 'anoInicio' deve possuir 4 dígitos!")
    @NotNull(message = "O campo 'anoInicio' deve ser preenchido!")
    @Column(nullable = false)
    private Integer anoInicio;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesConclusao' deve estar entre 1 e 12!")
    @NotNull(message = "O campo 'mesConclusao' deve ser preenchido!")
    @Column(nullable = false)
    private Integer mesConclusao;

    @Size(min = 4, max = 4, message = "O campo 'anoConclusao' deve possuir 4 dígitos!")
    @NotNull(message = "O campo 'anoConclusao' deve ser preenchido!")
    @Column(nullable = false)
    private Integer anoConclusao;

    @Override
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    @Override
    public NivelFormacao getNivel() {
        return nivel;
    }

    public void setNivel(NivelFormacao nivel) {
        this.nivel = nivel;
    }

    @Override
    public GrauFormacao getGrau() {
        return grau;
    }

    public void setGrau(GrauFormacao grau) {
        this.grau = grau;
    }

    @Override
    public SituacaoFormacao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoFormacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public Integer getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(Integer mesInicio) {
        this.mesInicio = mesInicio;
    }

    @Override
    public Integer getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(Integer anoInicio) {
        this.anoInicio = anoInicio;
    }

    @Override
    public Integer getMesConclusao() {
        return mesConclusao;
    }

    public void setMesConclusao(Integer mesConclusao) {
        this.mesConclusao = mesConclusao;
    }

    @Override
    public Integer getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(Integer anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

    @Override
    public String getEntityName() {
        return "Formação Acadêmica";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.curriculo);
        hash = 67 * hash + Objects.hashCode(this.curso);
        hash = 67 * hash + Objects.hashCode(this.instituicao);
        hash = 67 * hash + Objects.hashCode(this.mesInicio);
        hash = 67 * hash + Objects.hashCode(this.anoInicio);
        hash = 67 * hash + Objects.hashCode(this.mesConclusao);
        hash = 67 * hash + Objects.hashCode(this.anoConclusao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormacaoAcademica other = (FormacaoAcademica) obj;
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.instituicao, other.instituicao)) {
            return false;
        }
        if (!Objects.equals(this.curriculo, other.curriculo)) {
            return false;
        }
        if (!Objects.equals(this.mesInicio, other.mesInicio)) {
            return false;
        }
        if (!Objects.equals(this.anoInicio, other.anoInicio)) {
            return false;
        }
        if (!Objects.equals(this.mesConclusao, other.mesConclusao)) {
            return false;
        }
        return Objects.equals(this.anoConclusao, other.anoConclusao);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity.curriculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import org.hibernate.validator.constraints.Range;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculoManyToOne;
import software.gabriel.easyjobs.model.curriculo.ExperienciaProfissionalModel;
import software.gabriel.easyjobs.model.base.NamedEntityModel;

/**
 *
 * @author gabriel
 */
@Entity
public class ExperienciaProfissional
        extends AbstractCampoCurriculoManyToOne
        implements ExperienciaProfissionalModel, NamedEntityModel {

    @NotBlank(message = "O campo 'funcao' deve ser preenchido!")
    @Column(nullable = false)
    private String funcao;

    @NotBlank(message = "O campo 'empresa' deve ser preenchido!")
    @Column(nullable = false)
    private String empresa;

    @NotNull(message = "O campo 'empregoAtual' deve ser preenchido!")
    @Column(nullable = false)
    private Boolean empregoAtual;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesInicio' deve estar entre 1 e 12!")
    @NotNull(message = "O campo 'mesInicio' deve ser preenchido!")
    @Column(nullable = false)
    private Integer mesInicio;

    @NotNull(message = "O campo 'anoInicio' deve ser preenchido!")
    @Column(nullable = false)
    private Integer anoInicio;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesSaida' deve estar entre 1 e 12!")
    private Integer mesSaida;

    private Integer anoSaida;

    @NotBlank(message = "O campo 'descricao' deve ser preenchido!")
    @Column(nullable = false)
    private String descricao;

    @Override
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public Boolean getEmpregoAtual() {
        return empregoAtual;
    }

    public void setEmpregoAtual(Boolean empregoAtual) {
        this.empregoAtual = empregoAtual;
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
    public Integer getMesSaida() {
        return mesSaida;
    }

    public void setMesSaida(Integer mesSaida) {
        this.mesSaida = mesSaida;
    }

    @Override
    public Integer getAnoSaida() {
        return anoSaida;
    }

    public void setAnoSaida(Integer anoSaida) {
        this.anoSaida = anoSaida;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getEntityName() {
        return "Experiência Profissional";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.curriculo);
        hash = 31 * hash + Objects.hashCode(this.funcao);
        hash = 31 * hash + Objects.hashCode(this.empresa);
        hash = 31 * hash + Objects.hashCode(this.mesInicio);
        hash = 31 * hash + Objects.hashCode(this.anoInicio);
        hash = 31 * hash + Objects.hashCode(this.mesSaida);
        hash = 31 * hash + Objects.hashCode(this.anoSaida);
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
        final ExperienciaProfissional other = (ExperienciaProfissional) obj;
        if (!Objects.equals(this.funcao, other.funcao)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
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
        if (!Objects.equals(this.mesSaida, other.mesSaida)) {
            return false;
        }
        return Objects.equals(this.anoSaida, other.anoSaida);
    }

}

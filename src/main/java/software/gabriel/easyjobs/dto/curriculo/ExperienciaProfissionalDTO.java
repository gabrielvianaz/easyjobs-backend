/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.curriculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.curriculo.ExperienciaProfissional;

/**
 *
 * @author gabriel
 */
public class ExperienciaProfissionalDTO
        extends CampoCurriculoDTO<ExperienciaProfissional> {

    @NotBlank(message = "O campo 'funcao' deve ser preenchido!")
    private String funcao;

    @NotBlank(message = "O campo 'empresa' deve ser preenchido!")
    private String empresa;

    @NotNull(message = "O campo 'empregoAtual' deve ser preenchido!")
    private Boolean empregoAtual;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesInicio' deve estar entre 1 e 12!")
    @NotNull(message = "O campo 'mesInicio' deve ser preenchido!")
    private Integer mesInicio;

    @NotNull(message = "O campo 'anoInicio' deve ser preenchido!")
    private Integer anoInicio;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesSaida' deve estar entre 1 e 12!")
    private Integer mesSaida;

    private Integer anoSaida;

    @NotBlank(message = "O campo 'descricao' deve ser preenchido!")
    private String descricao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Boolean getEmpregoAtual() {
        return empregoAtual;
    }

    public void setEmpregoAtual(Boolean empregoAtual) {
        this.empregoAtual = empregoAtual;
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

    public Integer getMesSaida() {
        return mesSaida;
    }

    public void setMesSaida(Integer mesSaida) {
        this.mesSaida = mesSaida;
    }

    public Integer getAnoSaida() {
        return anoSaida;
    }

    public void setAnoSaida(Integer anoSaida) {
        this.anoSaida = anoSaida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

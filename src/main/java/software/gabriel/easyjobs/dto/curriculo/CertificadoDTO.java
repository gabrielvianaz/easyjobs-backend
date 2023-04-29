/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.curriculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.curriculo.Certificado;

/**
 *
 * @author gabriel
 */
public class CertificadoDTO
        extends CampoCurriculoDTO<Certificado> {

    @NotBlank(message = "O campo 'titulo' deve ser preenchido!")
    private String titulo;

    @NotBlank(message = "O campo 'instituicao' deve ser preenchido!")
    private String instituicao;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesInicio' deve estar entre 1 e 12!")
    @NotNull(message = "O campo 'mesEmissao' deve ser preenchido!")
    private Integer mesEmissao;

    @Size(min = 4, max = 4, message = "O campo 'anoInicio' deve possuir 4 dígitos!")
    @NotNull(message = "O campo 'anoEmissao' deve ser preenchido!")
    private Integer anoEmissao;

    private String url;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Integer getMesEmissao() {
        return mesEmissao;
    }

    public void setMesEmissao(Integer mesEmissao) {
        this.mesEmissao = mesEmissao;
    }

    public Integer getAnoEmissao() {
        return anoEmissao;
    }

    public void setAnoEmissao(Integer anoEmissao) {
        this.anoEmissao = anoEmissao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

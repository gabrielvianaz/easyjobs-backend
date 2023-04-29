/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity.curriculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;
import org.hibernate.validator.constraints.Range;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculoManyToOne;
import software.gabriel.easyjobs.model.curriculo.CertificadoModel;
import software.gabriel.easyjobs.model.base.NamedEntityModel;

/**
 *
 * @author gabriel
 */
@Entity
public class Certificado
        extends AbstractCampoCurriculoManyToOne
        implements CertificadoModel, NamedEntityModel {

    @NotBlank(message = "O campo 'titulo' deve ser preenchido!")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "O campo 'instituicao' deve ser preenchido!")
    @Column(nullable = false)
    private String instituicao;

    @Range(min = 1, max = 12, message = "O valor do campo 'mesInicio' deve estar entre 1 e 12!")
    @NotNull(message = "O campo 'mesEmissao' deve ser preenchido!")
    @Column(nullable = false)
    private Integer mesEmissao;

    @Size(min = 4, max = 4, message = "O campo 'anoInicio' deve possuir 4 dígitos!")
    @NotNull(message = "O campo 'anoEmissao' deve ser preenchido!")
    @Column(nullable = false)
    private Integer anoEmissao;

    private String url;

    @Override
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    @Override
    public Integer getMesEmissao() {
        return mesEmissao;
    }

    public void setMesEmissao(Integer mesEmissao) {
        this.mesEmissao = mesEmissao;
    }

    @Override
    public Integer getAnoEmissao() {
        return anoEmissao;
    }

    public void setAnoEmissao(Integer anoEmissao) {
        this.anoEmissao = anoEmissao;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getEntityName() {
        return "Certificado";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.curriculo);
        hash = 11 * hash + Objects.hashCode(this.titulo);
        hash = 11 * hash + Objects.hashCode(this.instituicao);
        hash = 11 * hash + Objects.hashCode(this.mesEmissao);
        hash = 11 * hash + Objects.hashCode(this.anoEmissao);
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
        final Certificado other = (Certificado) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.instituicao, other.instituicao)) {
            return false;
        }
        if (!Objects.equals(this.curriculo, other.curriculo)) {
            return false;
        }
        if (!Objects.equals(this.mesEmissao, other.mesEmissao)) {
            return false;
        }
        return Objects.equals(this.anoEmissao, other.anoEmissao);
    }

}

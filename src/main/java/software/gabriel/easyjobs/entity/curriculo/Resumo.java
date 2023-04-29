/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity.curriculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculoOneToOne;
import software.gabriel.easyjobs.model.curriculo.ResumoModel;

/**
 *
 * @author gabriel
 */
@Entity
public class Resumo
        extends AbstractCampoCurriculoOneToOne
        implements ResumoModel {

    @NotBlank(message = "O campo 'texto' deve ser preenchido!")
    @Column(nullable = false)
    private String texto;

    @Override
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String getEntityName() {
        return "Resumo";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.curriculo);
        hash = 79 * hash + Objects.hashCode(this.texto);
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
        final Resumo other = (Resumo) obj;
        if (!Objects.equals(this.curriculo, other.curriculo)) {
            return false;
        }
        return Objects.equals(this.texto, other.texto);
    }

}

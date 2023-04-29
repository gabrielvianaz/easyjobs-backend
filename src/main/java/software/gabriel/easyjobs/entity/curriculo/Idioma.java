/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity.curriculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculoManyToOne;
import software.gabriel.easyjobs.enums.curriculo.NivelIdioma;
import software.gabriel.easyjobs.enums.curriculo.NomeIdioma;
import software.gabriel.easyjobs.model.curriculo.IdiomaModel;
import software.gabriel.easyjobs.model.base.NamedEntityModel;

/**
 *
 * @author gabriel
 */
@Entity
public class Idioma
        extends AbstractCampoCurriculoManyToOne
        implements IdiomaModel, NamedEntityModel {

    @NotNull(message = "O campo 'nome' deve ser preenchido!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NomeIdioma nome;

    @NotNull(message = "O campo 'nivel' deve ser preenchido!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelIdioma nivel;

    @Override
    public NomeIdioma getNome() {
        return nome;
    }

    public void setNome(NomeIdioma nome) {
        this.nome = nome;
    }

    @Override
    public NivelIdioma getNivel() {
        return nivel;
    }

    public void setNivel(NivelIdioma nivel) {
        this.nivel = nivel;
    }

    @Override
    public String getEntityName() {
        return "Idioma";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.curriculo);
        hash = 97 * hash + Objects.hashCode(this.nome);
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
        final Idioma other = (Idioma) obj;
        if (!Objects.equals(this.curriculo, other.curriculo)) {
            return false;
        }
        return this.nome == other.nome;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity.curriculo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import software.gabriel.easyjobs.entity.base.AbstractEntity;
import software.gabriel.easyjobs.entity.candidato.Candidato;
import software.gabriel.easyjobs.model.curriculo.CurriculoModel;

/**
 *
 * @author gabriel
 */
@Entity
public class Curriculo
        extends AbstractEntity
        implements CurriculoModel {

    @OneToOne
    @JoinColumn(name = "candidato_id", nullable = false, unique = true)
    private Candidato candidato;

    @OneToOne(mappedBy = "curriculo")
    private Resumo resumo;

    @OneToMany(mappedBy = "curriculo")
    private List<ExperienciaProfissional> experienciasProfissionais = new ArrayList<>();

    @OneToMany(mappedBy = "curriculo")
    private List<FormacaoAcademica> formacoesAcademicas = new ArrayList<>();

    @OneToMany(mappedBy = "curriculo")
    private List<Certificado> certificados = new ArrayList<>();

    @OneToMany(mappedBy = "curriculo")
    private List<Idioma> idiomas = new ArrayList<>();

    public Curriculo(Candidato candidato) {
        this.candidato = candidato;
    }

    public Curriculo() {
    }

    @Override
    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public Resumo getResumo() {
        return resumo;
    }

    public void setResumo(Resumo resumo) {
        this.resumo = resumo;
    }

    @Override
    public List<ExperienciaProfissional> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void setExperienciasProfissionais(List<ExperienciaProfissional> experienciasProfissionais) {
        this.experienciasProfissionais = experienciasProfissionais;
    }

    @Override
    public List<FormacaoAcademica> getFormacoesAcademicas() {
        return formacoesAcademicas;
    }

    public void setFormacoesAcademicas(List<FormacaoAcademica> formacoesAcademicas) {
        this.formacoesAcademicas = formacoesAcademicas;
    }

    @Override
    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    @Override
    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.candidato);
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
        final Curriculo other = (Curriculo) obj;
        return Objects.equals(this.candidato, other.candidato);
    }

}

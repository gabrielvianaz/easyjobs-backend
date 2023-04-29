/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity.base.curriculo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.model.base.curriculo.CampoCurriculoModel;

/**
 *
 * @author gabriel
 */
@MappedSuperclass
public abstract class AbstractCampoCurriculoOneToOne
        extends AbstractCampoCurriculo
        implements CampoCurriculoModel {

    @OneToOne
    @JoinColumn(name = "curriculo_id", nullable = false)
    protected Curriculo curriculo;

    @Override
    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

}

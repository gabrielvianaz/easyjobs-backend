/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.base.curriculo;

import com.fasterxml.jackson.annotation.JsonProperty;
import software.gabriel.easyjobs.dto.base.AbstractDTO;
import software.gabriel.easyjobs.dto.curriculo.CurriculoDTO;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculo;

/**
 *
 * @author gabriel
 */
public class CampoCurriculoDTO<T extends AbstractCampoCurriculo>
        extends AbstractDTO<T> {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CurriculoDTO curriculo;

    public CurriculoDTO getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(CurriculoDTO curriculo) {
        this.curriculo = curriculo;
    }

}

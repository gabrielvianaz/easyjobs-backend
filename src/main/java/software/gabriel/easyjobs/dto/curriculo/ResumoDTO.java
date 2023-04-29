/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.curriculo;

import jakarta.validation.constraints.NotBlank;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.curriculo.Resumo;

/**
 *
 * @author gabriel
 */
public class ResumoDTO
        extends CampoCurriculoDTO<Resumo> {

    @NotBlank(message = "O campo 'texto' deve ser preenchido!")
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}

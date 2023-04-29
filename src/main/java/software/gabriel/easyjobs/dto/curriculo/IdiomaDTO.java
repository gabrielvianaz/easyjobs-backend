/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.curriculo;

import jakarta.validation.constraints.NotNull;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.curriculo.Idioma;
import software.gabriel.easyjobs.enums.curriculo.NivelIdioma;
import software.gabriel.easyjobs.enums.curriculo.NomeIdioma;

/**
 *
 * @author gabriel
 */
public class IdiomaDTO
        extends CampoCurriculoDTO<Idioma> {

    @NotNull(message = "O campo 'nome' deve ser preenchido!")
    private NomeIdioma nome;

    @NotNull(message = "O campo 'nivel' deve ser preenchido!")
    private NivelIdioma nivel;

    public NomeIdioma getNome() {
        return nome;
    }

    public void setNome(NomeIdioma nome) {
        this.nome = nome;
    }

    public NivelIdioma getNivel() {
        return nivel;
    }

    public void setNivel(NivelIdioma nivel) {
        this.nivel = nivel;
    }

}

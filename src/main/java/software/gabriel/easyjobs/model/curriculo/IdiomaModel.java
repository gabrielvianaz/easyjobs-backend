/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model.curriculo;

import software.gabriel.easyjobs.model.base.curriculo.CampoCurriculoModel;
import software.gabriel.easyjobs.enums.curriculo.NivelIdioma;
import software.gabriel.easyjobs.enums.curriculo.NomeIdioma;

/**
 *
 * @author gabriel
 */
public interface IdiomaModel 
        extends CampoCurriculoModel {
    
    NomeIdioma getNome();
    
    NivelIdioma getNivel();
    
}

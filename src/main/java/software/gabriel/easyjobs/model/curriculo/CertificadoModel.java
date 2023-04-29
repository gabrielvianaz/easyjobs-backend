/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model.curriculo;

import software.gabriel.easyjobs.model.base.curriculo.CampoCurriculoModel;

/**
 *
 * @author gabriel
 */
public interface CertificadoModel
        extends CampoCurriculoModel {

    String getTitulo();

    String getInstituicao();

    Integer getMesEmissao();

    Integer getAnoEmissao();

    String getUrl();

}

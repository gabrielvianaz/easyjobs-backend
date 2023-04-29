/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model.empresa;

import java.time.LocalDate;
import software.gabriel.easyjobs.entity.security.Usuario;
import software.gabriel.easyjobs.model.base.EntityModel;

/**
 *
 * @author gabriel
 */
public interface EmpresaModel
        extends EntityModel {

    String getRazaoSocial();

    String getNomeFantasia();

    String getCnpj();

    LocalDate getDataFundacao();

    String getCidade();

    String getEstado();

    String getResumo();

    String getUrlLogo();

    Usuario getUsuario();

}

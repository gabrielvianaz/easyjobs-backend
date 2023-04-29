/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model.security;

import java.util.Set;
import software.gabriel.easyjobs.entity.security.Role;
import software.gabriel.easyjobs.model.base.EntityModel;

/**
 *
 * @author gabriel
 */
public interface UsuarioModel
        extends EntityModel {

    String getEmail();

    String getSenha();

    Boolean getAtivo();

    Set<Role> getRoles();

}

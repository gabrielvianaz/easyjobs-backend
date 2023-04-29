/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model.security;

import java.time.LocalDateTime;
import software.gabriel.easyjobs.entity.security.Usuario;
import software.gabriel.easyjobs.model.base.EntityModel;

/**
 *
 * @author gabriel
 */
public interface AtivacaoModel 
        extends EntityModel {
    
    Usuario getUsuario();
    
    String getCodigo();
    
    LocalDateTime getGeracao();
    
    LocalDateTime getExpiracao();
    
}

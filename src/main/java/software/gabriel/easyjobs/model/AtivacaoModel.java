/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model;

import java.time.LocalDateTime;
import software.gabriel.easyjobs.entity.Usuario;

/**
 *
 * @author gabriel
 */
public interface AtivacaoModel 
        extends BaseModel {
    
    Usuario getUsuario();
    
    String getCodigo();
    
    LocalDateTime getExpiracao();
    
}

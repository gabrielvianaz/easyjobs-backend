/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.model;

/**
 *
 * @author gabriel
 */
public interface UsuarioModel 
        extends BaseModel {
    
    String getEmail();
    
    String getSenha();
    
    Boolean getAtivo();
    
    Boolean getVinculado();

}

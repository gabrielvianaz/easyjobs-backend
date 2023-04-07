/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.ativacao;

/**
 *
 * @author gabriel
 */
public class CodigoAtivacaoExpiradoException extends RuntimeException {
    
    public CodigoAtivacaoExpiradoException() {
        super("Código de ativação expirado. Geramos um novo código!");
    }
    
}

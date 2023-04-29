/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.security;

/**
 *
 * @author gabriel
 */
public class AtivacaoInexistenteException 
        extends RuntimeException {
    
    public AtivacaoInexistenteException() {
        super("Não existe ativação pendente para o usuário informado!");
    }
    
}

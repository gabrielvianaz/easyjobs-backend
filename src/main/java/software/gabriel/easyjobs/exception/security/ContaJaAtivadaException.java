/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.security;

/**
 *
 * @author gabriel
 */
public class ContaJaAtivadaException extends RuntimeException {
    
    public ContaJaAtivadaException() {
        super("Essa conta já se encontra ativa!");
    }
    
}

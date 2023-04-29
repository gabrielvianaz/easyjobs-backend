/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.curriculo;

/**
 *
 * @author gabriel
 */
public class ResumoJaCadastradoException extends RuntimeException {
    
    public ResumoJaCadastradoException() {
        super("O candidato já possui resumo cadastrado em seu currículo!");
    }
    
}

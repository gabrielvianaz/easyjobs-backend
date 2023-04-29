/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.curriculo;

/**
 *
 * @author gabriel
 */
public class ResumoNaoCadastradoException extends RuntimeException {
    
    public ResumoNaoCadastradoException() {
        super("O candidato não possui resumo cadastrado em seu currículo!");
    }
    
}

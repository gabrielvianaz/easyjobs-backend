/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.usuario;

/**
 *
 * @author gabriel
 */
public class EmailNaoCadastradoException extends RuntimeException {

    public EmailNaoCadastradoException() {
        super("O e-mail informado não se encontra cadastrado!");
    }
    
}

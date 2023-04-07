/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.mail;

/**
 *
 * @author gabriel
 */
public class ErroEnvioEmailException extends RuntimeException {

    public ErroEnvioEmailException() {
        super("Ocorreu um erro no envio do email!");
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.enums.curriculo;

/**
 *
 * @author gabriel
 */
public enum SituacaoFormacao {
    COMPLETO("Completo"),
    CURSANDO("Cursando"),
    INCOMPLETO("Incompleto");
    
    private final String nome;

    private SituacaoFormacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

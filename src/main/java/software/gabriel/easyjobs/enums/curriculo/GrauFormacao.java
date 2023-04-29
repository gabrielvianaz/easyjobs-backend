/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.enums.curriculo;

/**
 *
 * @author gabriel
 */
public enum GrauFormacao {
    GRADUACAO("Graduação"),
    POS_GRADUACAO("Pós-Graduação"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado");

    private final String nome;

    private GrauFormacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

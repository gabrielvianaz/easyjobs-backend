/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.enums.curriculo;

/**
 *
 * @author gabriel
 */
public enum NomeIdioma {
    ALEMAO("Alemão"),
    ESPANHOL("Espanhol"),
    FRANCES("Francês"),
    HINDI("Hindi"),
    INGLES("Inglês"),
    ITALIANO("Italiano"),
    JAPONES("Japonês"),
    MANDARIM("Mandarim"),
    PORTUGUES("Português"),
    RUSSO("Russo");

    private final String nome;

    private NomeIdioma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

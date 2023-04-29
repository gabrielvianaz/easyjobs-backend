/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.enums.curriculo;

/**
 *
 * @author gabriel
 */
public enum NivelIdioma {
    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado"),
    FLUENTE("Fluente");
    
    private final String nome;

    private NivelIdioma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

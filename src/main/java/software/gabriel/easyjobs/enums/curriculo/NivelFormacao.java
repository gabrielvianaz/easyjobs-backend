/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.enums.curriculo;

/**
 *
 * @author gabriel
 */
public enum NivelFormacao {
    FUNDAMENTAL("Fundamental"),
    MEDIO("Médio"),
    SUPERIOR("Superior"),
    TECNICO("Técnico");
    
    private final String nome;

    private NivelFormacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

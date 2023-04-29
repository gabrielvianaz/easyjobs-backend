/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.enums.candidato;

/**
 *
 * @author gabriel
 */
public enum GeneroCandidato {
    MASCULINO("M"),
    FEMININO("F");

    private final String simbolo;

    private GeneroCandidato(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

}

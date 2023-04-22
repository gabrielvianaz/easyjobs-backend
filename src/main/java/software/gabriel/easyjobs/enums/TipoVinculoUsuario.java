/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.enums;

/**
 *
 * @author gabriel
 */
public enum TipoVinculoUsuario {
    CANDIDATO("Candidato"),
    EMPRESA("Empresa");

    private final String nome;

    private TipoVinculoUsuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

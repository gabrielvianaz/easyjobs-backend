/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.enums.TipoVinculoUsuario;

/**
 *
 * @author gabriel
 */
@JsonInclude(Include.NON_NULL)
public class UsuarioDTO
        extends BaseDTO<Usuario> {

    @NotBlank(message = "O campo 'email' deve ser preenchido!")
    @Email(message = "O e-mail informado é inválido!")
    private String email;

    @NotBlank(message = "O campo 'senha' deve ser preenchido!")
    @Size(min = 8, message = "A senha deve possuir no mínimo 8 caracteres!")
    private String senha;

    private Boolean vinculado;

    private TipoVinculoUsuario tipoVinculo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getVinculado() {
        return vinculado;
    }

    public void setVinculado(Boolean vinculado) {
        this.vinculado = vinculado;
    }

    public TipoVinculoUsuario getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(TipoVinculoUsuario tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

}

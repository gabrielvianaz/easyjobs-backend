/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import software.gabriel.easyjobs.enums.TipoVinculoUsuario;
import software.gabriel.easyjobs.model.UsuarioModel;

/**
 *
 * @author gabriel
 */
@Entity
public class Usuario
        extends BaseEntity
        implements UsuarioModel, UserDetails {

    @NotBlank(message = "O campo 'email' deve ser preenchido!")
    @Email(message = "O e-mail informado é inválido!")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O campo 'senha' deve ser preenchido!")
    @Size(min = 8, message = "A senha deve possuir no mínimo 8 caracteres!")
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private Boolean vinculado;

    @Enumerated(EnumType.STRING)
    private TipoVinculoUsuario tipoVinculo;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public Boolean getVinculado() {
        return vinculado;
    }

    public void setVinculado(Boolean vinculado) {
        this.vinculado = vinculado;
    }

    @Override
    public TipoVinculoUsuario getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(TipoVinculoUsuario tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return getSenha();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getAtivo();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.email, other.email);
    }

}

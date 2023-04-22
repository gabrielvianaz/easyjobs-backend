/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Objects;
import software.gabriel.easyjobs.model.AtivacaoModel;

/**
 *
 * @author gabriel
 */
@Entity
public class Ativacao
        extends BaseEntity
        implements AtivacaoModel {

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Column(nullable = false, length = 6)
    private String codigo;

    @Column(nullable = false)
    private LocalDateTime geracao;

    @Column(nullable = false)
    private LocalDateTime expiracao;

    public Ativacao(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Ativacao() {        
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public LocalDateTime getGeracao() {
        return geracao;
    }

    public void setGeracao(LocalDateTime geracao) {
        this.geracao = geracao;
    }

    @Override
    public java.time.LocalDateTime getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(java.time.LocalDateTime expiracao) {
        this.expiracao = expiracao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.usuario);
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
        final Ativacao other = (Ativacao) obj;
        return Objects.equals(this.usuario, other.usuario);
    }

}

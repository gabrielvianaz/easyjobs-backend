/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CPF;
import software.gabriel.easyjobs.enums.GeneroCandidato;
import software.gabriel.easyjobs.model.CandidatoModel;

/**
 *
 * @author gabriel
 */
@Entity
public class Candidato
        extends BaseEntity
        implements CandidatoModel {

    @NotBlank(message = "O campo 'nome' deve ser preenchido!")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O campo 'cpf' deve ser preenchido!")
    @Size(min = 11, max = 11, message = "O CPF deve possuir 11 caracteres!")
    @CPF(message = "O CPF informado é inválido!")
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
    @NotNull(message = "O campo 'dataNascimento' deve ser preenchido!")
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotNull(message = "O campo 'genero' deve ser preenchido!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroCandidato genero;

    @NotBlank(message = "O campo 'cidade' deve ser preenchido!")
    @Column(nullable = false)
    private String cidade;

    @NotBlank(message = "O campo 'estado' deve ser preenchido!")
    @Size(min = 2, max = 2, message = "O nome do estado deve possuir 2 caracteres!")
    @Column(nullable = false, length = 2)
    private String estado;

    @OneToOne
    @NotNull(message = "O campo 'usuario' deve ser preenchido!")
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public GeneroCandidato getGenero() {
        return genero;
    }

    public void setGenero(GeneroCandidato genero) {
        this.genero = genero;
    }

    @Override
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

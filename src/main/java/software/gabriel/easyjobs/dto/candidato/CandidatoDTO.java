/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.candidato;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CPF;
import software.gabriel.easyjobs.dto.base.AbstractDTO;
import software.gabriel.easyjobs.dto.curriculo.CurriculoDTO;
import software.gabriel.easyjobs.entity.candidato.Candidato;
import software.gabriel.easyjobs.enums.candidato.GeneroCandidato;

/**
 *
 * @author gabriel
 */
public class CandidatoDTO
        extends AbstractDTO<Candidato> {

    @NotBlank(message = "O campo 'nome' deve ser preenchido!")
    private String nome;

    @NotBlank(message = "O campo 'cpf' deve ser preenchido!")
    @Size(min = 11, max = 11, message = "O CPF deve possuir 11 caracteres!")
    @CPF(message = "O CPF informado é inválido!")
    private String cpf;

    @NotNull(message = "O campo 'dataNascimento' deve ser preenchido!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo 'genero' deve ser preenchido!")
    private GeneroCandidato genero;

    @NotBlank(message = "O campo 'cidade' deve ser preenchido!")
    private String cidade;

    @NotBlank(message = "O campo 'estado' deve ser preenchido!")
    @Size(min = 2, max = 2, message = "O nome do estado deve possuir 2 caracteres!")
    private String estado;

    @JsonIgnoreProperties({"candidato"})
    private CurriculoDTO curriculo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public GeneroCandidato getGenero() {
        return genero;
    }

    public void setGenero(GeneroCandidato genero) {
        this.genero = genero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CurriculoDTO getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(CurriculoDTO curriculo) {
        this.curriculo = curriculo;
    }

}

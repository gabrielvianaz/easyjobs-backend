/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;
import software.gabriel.easyjobs.entity.Empresa;

/**
 *
 * @author gabriel
 */
public class EmpresaDTO
        extends BaseDTO<Empresa> {

    @NotBlank(message = "O campo 'razaoSocial' deve ser preenchido!")
    private String razaoSocial;

    @NotBlank(message = "O campo 'nomeFantasia' deve ser preenchido!")
    private String nomeFantasia;

    @NotBlank(message = "O campo 'cnpj' deve ser preenchido!")
    @Size(min = 14, max = 14, message = "O CNPJ deve possuir 14 caracteres!")
    @CNPJ(message = "O CNPJ informado é inválido!")
    private String cnpj;

    @NotNull(message = "O campo 'dataFundacao' deve ser preenchido!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;

    @NotBlank(message = "O campo 'cidade' deve ser preenchido!")
    private String cidade;

    @NotBlank(message = "O campo 'estado' deve ser preenchido!")
    @Size(min = 2, max = 2, message = "O nome do estado deve possuir 2 caracteres!")
    private String estado;

    private String resumo;

    @URL(message = "O URL informado é inválido!")
    private String urlLogo;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

}

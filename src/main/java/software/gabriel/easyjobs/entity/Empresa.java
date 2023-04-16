/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;
import software.gabriel.easyjobs.model.EmpresaModel;

/**
 *
 * @author gabriel
 */
@Entity
public class Empresa
        extends BaseEntity
        implements EmpresaModel {

    @NotBlank(message = "O campo 'razaoSocial' deve ser preenchido!")
    @Column(nullable = false)
    private String razaoSocial;

    @NotBlank(message = "O campo 'nomeFantasia' deve ser preenchido!")
    @Column(nullable = false)
    private String nomeFantasia;

    @NotBlank(message = "O campo 'cnpj' deve ser preenchido!")
    @Size(min = 14, max = 14, message = "O CNPJ deve possuir 14 caracteres!")
    @CNPJ(message = "O CNPJ informado é inválido!")
    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @NotNull(message = "O campo 'dataFundacao' deve ser preenchido!")
    @Column(nullable = false)
    private LocalDate dataFundacao;

    @NotBlank(message = "O campo 'cidade' deve ser preenchido!")
    @Column(nullable = false)
    private String cidade;

    @NotBlank(message = "O campo 'estado' deve ser preenchido!")
    @Size(min = 2, max = 2, message = "O nome do estado deve possuir 2 caracteres!")
    @Column(nullable = false, length = 2)
    private String estado;

    private String resumo;

    @URL(message = "O URL informado é inválido!")
    private String urlLogo;

    @OneToOne
    @NotNull(message = "O campo 'usuario' deve ser preenchido!")
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Override
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
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
    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

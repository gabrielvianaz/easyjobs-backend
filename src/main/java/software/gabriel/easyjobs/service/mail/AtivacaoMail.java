/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.mail;

import software.gabriel.easyjobs.entity.Ativacao;

/**
 *
 * @author gabriel
 */
public class AtivacaoMail {

    private Ativacao ativacao;

    public AtivacaoMail(Ativacao ativacao) {
        this.ativacao = ativacao;
    }

    public Ativacao getAtivacao() {
        return ativacao;
    }

    public void setAtivacao(Ativacao ativacao) {
        this.ativacao = ativacao;
    }

    public String getHtml() {
        String html = "<html>\n"
                + "     <body style=\"text-align: center;width: 100%\">\n"
                + "         <h1 style=\"margin: 20px;color: #f97c09\">Seja bem-vindo ao EasyJobs!</h1>\n"
                + "         <p style=\"margin: 0;color: #f97c09\">Para continuar seu cadastro, utilize o código de ativação abaixo:</p>\n"
                + "         <p style=\"font-weight: bold;font-size: 1.25rem;margin-top: 20px; color: #fff;background: #f97c09;padding: 20px; border-radius: 5px; display: inline-block\">$CODIGO_ATIVACAO</p>\n"
                + "     </body>\n"
                + "</html>";
        html = html.replace("$CODIGO_ATIVACAO", ativacao.getCodigo());

        return html;
    }

}

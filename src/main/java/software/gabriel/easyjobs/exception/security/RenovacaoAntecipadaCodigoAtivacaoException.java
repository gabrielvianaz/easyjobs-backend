/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.security;

import software.gabriel.easyjobs.utils.AtivacaoUtils;

/**
 *
 * @author gabriel
 */
public class RenovacaoAntecipadaCodigoAtivacaoException
        extends RuntimeException {

    public RenovacaoAntecipadaCodigoAtivacaoException() {
        super(String.format("O código de ativação só pode ser renovado após um intervalo mínimo de %d minutos desde a última tentativa de envio. Tente novamente mais tarde.",
                AtivacaoUtils.MINUTOS_RENOVACAO_CODIGO_ATIVACAO));
    }

}

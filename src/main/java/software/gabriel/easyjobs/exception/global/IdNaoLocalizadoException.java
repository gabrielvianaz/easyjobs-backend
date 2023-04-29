/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.exception.global;

import java.lang.reflect.InvocationTargetException;
import software.gabriel.easyjobs.model.base.NamedEntityModel;

/**
 *
 * @author gabriel
 */
public class IdNaoLocalizadoException extends RuntimeException {

    private String mensagem;

    public IdNaoLocalizadoException(Class<? extends NamedEntityModel> classe) {
        super();
        try {
            NamedEntityModel namedEntity = classe.getDeclaredConstructor().newInstance();
            mensagem = String.format("Não localizamos %s com o id informado!", namedEntity.getEntityName());
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            mensagem = "Não localizamos a entidade com o id informado!";
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}

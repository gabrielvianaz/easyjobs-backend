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
public class EntidadeOutroUsuarioException extends RuntimeException {

    private String mensagem;

    public EntidadeOutroUsuarioException(Class<? extends NamedEntityModel> classe) {
        super();
        try {
            NamedEntityModel namedEntity = classe.getDeclaredConstructor().newInstance();
            mensagem = String.format("Esse(a) %s pertence a outro usuário!", namedEntity.getEntityName());
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            mensagem = "Essa entidade pertence a outro usuário!";
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}

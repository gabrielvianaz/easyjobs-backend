/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.entity.Ativacao;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.exception.ativacao.CodigoAtivacaoIncorretoException;
import software.gabriel.easyjobs.repository.AtivacaoRepository;

/**
 *
 * @author gabriel
 */
@Service
public class AtivacaoService {

    @Autowired
    AtivacaoRepository ativacaoRepository;

    public void cadastrar(Usuario usuario) {
        ativacaoRepository.save(new Ativacao(usuario));
    }
    
    public void ativar(Usuario usuario, String codigo) {
        Ativacao ativacao = ativacaoRepository.findByUsuario(usuario);
        if (codigo.equals(ativacao.getCodigo())) {
            ativacaoRepository.delete(ativacao);
        } else {
            throw new CodigoAtivacaoIncorretoException();
        }
    }

}

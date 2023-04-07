/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.entity.Ativacao;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.exception.ativacao.CodigoAtivacaoExpiradoException;
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
        ativacaoRepository.save(gerarCodigo(new Ativacao(usuario)));
    }

    public void ativar(Usuario usuario, String codigo) {
        Ativacao ativacao = ativacaoRepository.findByUsuario(usuario);
        if (LocalDateTime.now().isAfter(ativacao.getExpiracao())) {
            ativacaoRepository.delete(ativacao);
            cadastrar(usuario);
            throw new CodigoAtivacaoExpiradoException();
        } 
        if (codigo.equals(ativacao.getCodigo())) {
            ativacaoRepository.delete(ativacao);
        } else {
            throw new CodigoAtivacaoIncorretoException();
        }
    }

    private Ativacao gerarCodigo(Ativacao ativacao) {
        Random secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(secureRandom.nextInt(9));
        }

        ativacao.setCodigo(sb.toString());
        ativacao.setExpiracao(LocalDateTime.now().plusDays(1));

        return ativacao;
    }

}

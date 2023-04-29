/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.security;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.security.AtivacaoDTO;
import software.gabriel.easyjobs.dto.security.UsuarioDTO;
import software.gabriel.easyjobs.entity.security.Ativacao;
import software.gabriel.easyjobs.entity.security.Usuario;
import software.gabriel.easyjobs.exception.security.AtivacaoInexistenteException;
import software.gabriel.easyjobs.exception.security.CodigoAtivacaoExpiradoException;
import software.gabriel.easyjobs.exception.security.CodigoAtivacaoIncorretoException;
import software.gabriel.easyjobs.exception.security.RenovacaoAntecipadaCodigoAtivacaoException;
import software.gabriel.easyjobs.repository.security.AtivacaoRepository;
import software.gabriel.easyjobs.service.mail.AtivacaoMail;
import software.gabriel.easyjobs.service.mail.MailService;
import software.gabriel.easyjobs.utils.AtivacaoUtils;

/**
 *
 * @author gabriel
 */
@Service
public class AtivacaoService {

    @Autowired
    private AtivacaoRepository ativacaoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MailService mailService;

    public void cadastrar(Usuario usuario) {
        Ativacao ativacao = gerarCodigo(new Ativacao(usuario));
        ativacaoRepository.save(ativacao);
        enviarEmail(ativacao);
    }

    public void ativar(AtivacaoDTO ativacaoDTO) {
        Usuario usuario = usuarioService.findByEmail(ativacaoDTO.getEmail());
        Ativacao ativacao = validarExistenciaAtivacao(usuario);
        if (LocalDateTime.now().isAfter(ativacao.getExpiracao())) {
            renovarCodigo(ativacao, usuario);
            throw new CodigoAtivacaoExpiradoException();
        }
        if (ativacaoDTO.getCodigo().equals(ativacao.getCodigo())) {
            ativacaoRepository.delete(ativacao);
            usuarioService.ativar(usuario);
        } else {
            throw new CodigoAtivacaoIncorretoException();
        }
    }

    public void renovar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.findByEmail(usuarioDTO.getEmail());
        Ativacao ativacao = validarExistenciaAtivacao(usuario);
        renovarCodigo(ativacao, usuario);
    }

    private Ativacao gerarCodigo(Ativacao ativacao) {
        Random secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < AtivacaoUtils.TAMANHO_CODIGO_ATIVACAO; i++) {
            sb.append(secureRandom.nextInt(9));
        }

        ativacao.setCodigo(sb.toString());
        ativacao.setGeracao(LocalDateTime.now());
        ativacao.setExpiracao(LocalDateTime.now().plusDays(AtivacaoUtils.DIAS_EXPIRACAO_CODIGO_ATIVACAO));

        return ativacao;
    }

    private Ativacao validarExistenciaAtivacao(Usuario usuario) {
        Ativacao ativacao = ativacaoRepository.findByUsuario(usuario);
        if (ativacao == null) {
            throw new AtivacaoInexistenteException();
        }
        return ativacao;
    }

    private void renovarCodigo(Ativacao ativacao, Usuario usuario) {
        if (LocalDateTime.now().isBefore(ativacao.getGeracao().plusMinutes(AtivacaoUtils.MINUTOS_RENOVACAO_CODIGO_ATIVACAO))) {
            throw new RenovacaoAntecipadaCodigoAtivacaoException();
        }
        ativacaoRepository.delete(ativacao);
        cadastrar(usuario);
    }

    private void enviarEmail(Ativacao ativacao) {
        mailService.enviar(ativacao.getUsuario().getEmail(), "Código de Ativação  - EasyJobs", new AtivacaoMail(ativacao).getHtml());
    }

}

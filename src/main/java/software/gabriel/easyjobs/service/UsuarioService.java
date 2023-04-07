/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.AtivacaoDTO;
import software.gabriel.easyjobs.dto.UsuarioDTO;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.exception.usuario.ContaJaAtivadaException;
import software.gabriel.easyjobs.exception.usuario.EmailJaCadastradoException;
import software.gabriel.easyjobs.exception.usuario.EmailNaoCadastradoException;
import software.gabriel.easyjobs.mapper.UsuarioMapper;
import software.gabriel.easyjobs.repository.UsuarioRepository;

/**
 *
 * @author gabriel
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMapper usuarioMapper;

    @Autowired
    AtivacaoService ativacaoService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void cadastrar(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) == null) {
            Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
            usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
            usuario.setAtivo(false);
            usuarioRepository.save(usuario);
            ativacaoService.cadastrar(usuario);
        } else {
            throw new EmailJaCadastradoException();
        }
    }

    public void ativar(AtivacaoDTO ativacaoDTO) {
        Usuario usuario = usuarioRepository.findByEmail(ativacaoDTO.getEmail());

        if (usuario != null) {
            if (usuario.getAtivo() == false) {
                ativacaoService.ativar(usuario, ativacaoDTO.getCodigo());
                usuario.setAtivo(true);
                usuarioRepository.save(usuario);
            } else {
                throw new ContaJaAtivadaException();
            }
        } else {
            throw new EmailNaoCadastradoException();
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.UsuarioDTO;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.enums.TipoVinculoUsuario;
import software.gabriel.easyjobs.exception.usuario.EmailJaCadastradoException;
import software.gabriel.easyjobs.exception.usuario.EmailNaoCadastradoException;
import software.gabriel.easyjobs.exception.usuario.UsuarioJaVinculadoException;
import software.gabriel.easyjobs.mapper.UsuarioMapper;
import software.gabriel.easyjobs.repository.UsuarioRepository;
import software.gabriel.easyjobs.security.SecurityUtils;

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

    public void ativar(Usuario usuario) {
        usuario.setAtivo(true);
        usuarioRepository.save(usuario);
    }

    public void vincular(Usuario usuario, TipoVinculoUsuario tipoVinculo) {
        usuario.setTipoVinculo(tipoVinculo);
        usuarioRepository.save(usuario);
    }

    public UsuarioDTO recuperar() {
        Usuario usuario = SecurityUtils.getUsuarioAutenticado();
        return usuarioMapper.toDTO(usuario);
    }

    public Usuario findByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new EmailNaoCadastradoException();
        }
        return usuario;
    }

    public void validarVinculoUsuario(Usuario usuario) {
        if (usuario.getTipoVinculo() != null) {
            throw new UsuarioJaVinculadoException();
        }
    }

}

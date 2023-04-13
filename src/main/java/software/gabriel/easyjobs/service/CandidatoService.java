/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.CandidatoDTO;
import software.gabriel.easyjobs.entity.Candidato;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.enums.TipoVinculoUsuario;
import software.gabriel.easyjobs.mapper.CandidatoMapper;
import software.gabriel.easyjobs.repository.CandidatoRepository;
import software.gabriel.easyjobs.security.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class CandidatoService {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    CandidatoMapper candidatoMapper;

    @Autowired
    UsuarioService usuarioService;

    public void cadastrar(CandidatoDTO candidatoDTO) {
        Usuario usuario = SecurityUtils.getUsuarioAutenticado();
        usuarioService.validarVinculoUsuario(usuario);
        Candidato candidato = candidatoMapper.toEntity(candidatoDTO);
        candidato.setUsuario(usuario);
        candidatoRepository.save(candidato);
        usuarioService.vincular(usuario, TipoVinculoUsuario.CANDIDATO);
    }

}

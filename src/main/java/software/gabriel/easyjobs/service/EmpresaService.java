/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.EmpresaDTO;
import software.gabriel.easyjobs.entity.Empresa;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.enums.TipoVinculoUsuario;
import software.gabriel.easyjobs.mapper.EmpresaMapper;
import software.gabriel.easyjobs.repository.EmpresaRepository;
import software.gabriel.easyjobs.security.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EmpresaMapper empresaMapper;

    @Autowired
    UsuarioService usuarioService;

    public void cadastrar(EmpresaDTO empresaDTO) {
        Usuario usuario = SecurityUtils.getUsuarioAutenticado();
        usuarioService.validarVinculoUsuario(usuario);
        Empresa empresa = empresaMapper.toEntity(empresaDTO);
        empresa.setUsuario(usuario);
        empresaRepository.save(empresa);
        usuarioService.vincular(usuario, TipoVinculoUsuario.EMPRESA);
    }

}

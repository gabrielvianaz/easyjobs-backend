/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.empresa.EmpresaDTO;
import software.gabriel.easyjobs.entity.empresa.Empresa;
import software.gabriel.easyjobs.entity.security.Usuario;
import software.gabriel.easyjobs.mapper.empresa.EmpresaMapper;
import software.gabriel.easyjobs.repository.empresa.EmpresaRepository;
import software.gabriel.easyjobs.service.base.AbstractEntityService;
import software.gabriel.easyjobs.service.security.UsuarioService;
import software.gabriel.easyjobs.utils.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class EmpresaService
        extends AbstractEntityService<Empresa, EmpresaDTO, EmpresaRepository> {

    @Autowired
    private EmpresaMapper empresaMapper;

    @Autowired
    private UsuarioService usuarioService;

    public EmpresaService() {
        super(Empresa.class);
    }

    public void cadastrar(EmpresaDTO empresaDTO) {
        Usuario usuario = SecurityUtils.getUsuarioAutenticado();
        usuarioService.validarVinculoUsuario(usuario);
        Empresa empresa = empresaMapper.toEntity(empresaDTO);
        empresa.setUsuario(usuario);
        salvar(empresa);
        usuarioService.vincularEmpresa(usuario);
    }

    public void alterar(EmpresaDTO empresaDTO) {
        Empresa empresa = findByUsuarioAutenticado();
        salvar(aplicarDTO(empresa, empresaDTO));
    }
    
    public Empresa findByUsuarioAutenticado() {
        return repository.findByUsuario(SecurityUtils.getUsuarioAutenticado());
    }

    @Override
    protected Empresa aplicarDTO(Empresa empresa, EmpresaDTO empresaDTO) {
        empresa.setRazaoSocial(empresaDTO.getRazaoSocial());
        empresa.setNomeFantasia(empresaDTO.getNomeFantasia());
        empresa.setCnpj(empresaDTO.getCnpj());
        empresa.setDataFundacao(empresaDTO.getDataFundacao());
        empresa.setCidade(empresaDTO.getCidade());
        empresa.setEstado(empresaDTO.getEstado());
        empresa.setResumo(empresaDTO.getResumo());
        empresa.setUrlLogo(empresaDTO.getUrlLogo());
        return empresa;
    }

}

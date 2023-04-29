/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.candidato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.candidato.CandidatoDTO;
import software.gabriel.easyjobs.entity.candidato.Candidato;
import software.gabriel.easyjobs.entity.security.Usuario;
import software.gabriel.easyjobs.mapper.candidato.CandidatoMapper;
import software.gabriel.easyjobs.repository.candidato.CandidatoRepository;
import software.gabriel.easyjobs.service.base.AbstractEntityService;
import software.gabriel.easyjobs.service.curriculo.CurriculoService;
import software.gabriel.easyjobs.service.security.UsuarioService;
import software.gabriel.easyjobs.utils.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class CandidatoService 
        extends AbstractEntityService<Candidato, CandidatoDTO, CandidatoRepository> {

    @Autowired
    private CandidatoMapper candidatoMapper;

    @Autowired
    private CurriculoService curriculoService;

    @Autowired
    private UsuarioService usuarioService;

    public CandidatoService() {
        super(Candidato.class);
    }

    public void cadastrar(CandidatoDTO candidatoDTO) {
        Usuario usuario = SecurityUtils.getUsuarioAutenticado();
        usuarioService.validarVinculoUsuario(usuario);
        Candidato candidato = candidatoMapper.toEntity(candidatoDTO);
        candidato.setUsuario(usuario);
        salvar(candidato);
        curriculoService.cadastrar(candidato);
        usuarioService.vincularCandidato(usuario);
    }

    public Candidato findByUsuarioAutenticado() {
        return repository.findByUsuario(SecurityUtils.getUsuarioAutenticado());
    }

    @Override
    protected Candidato aplicarDTO(Candidato candidato, CandidatoDTO candidatoDTO) {
        candidato.setNome(candidatoDTO.getNome());
        candidato.setCpf(candidatoDTO.getCpf());
        candidato.setDataNascimento(candidatoDTO.getDataNascimento());
        candidato.setGenero(candidatoDTO.getGenero());
        candidato.setCidade(candidatoDTO.getCidade());
        candidato.setEstado(candidatoDTO.getEstado());
        return candidato;
    }

}

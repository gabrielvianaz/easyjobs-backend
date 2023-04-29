/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.curriculo;

import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.curriculo.ResumoDTO;
import software.gabriel.easyjobs.entity.curriculo.Resumo;
import software.gabriel.easyjobs.exception.curriculo.ResumoJaCadastradoException;
import software.gabriel.easyjobs.exception.curriculo.ResumoNaoCadastradoException;
import software.gabriel.easyjobs.repository.curriculo.ResumoRepository;
import software.gabriel.easyjobs.service.base.curriculo.AbstractCampoCurriculoService;

/**
 *
 * @author gabriel
 */
@Service
public class ResumoService
        extends AbstractCampoCurriculoService<Resumo, ResumoDTO, ResumoRepository> {

    public ResumoService() {
        super(Resumo.class);
    }

    public void cadastrar(ResumoDTO resumoDTO) {
        validarCadastro();
        Resumo resumo = mapToEntity(resumoDTO);
        resumo.setCurriculo(getCurriculoCandidatoAutenticado());
        salvar(resumo);
    }

    public void alterar(ResumoDTO resumoDTO) {
        validarAlteracao();
        Resumo resumo = getCurriculoCandidatoAutenticado().getResumo();
        salvar(aplicarDTO(resumo, resumoDTO));
    }

    private Resumo findByCurriculo() {
        return repository.findByCurriculo(getCurriculoCandidatoAutenticado());
    }

    public void validarCadastro() {
        if (findByCurriculo() != null) {
            throw new ResumoJaCadastradoException();
        }
    }

    public void validarAlteracao() {
        if (findByCurriculo() == null) {
            throw new ResumoNaoCadastradoException();
        }
    }

    @Override
    protected Resumo aplicarDTO(Resumo resumo, ResumoDTO resumoDTO) {
        resumo.setTexto(resumoDTO.getTexto());
        return resumo;
    }

}

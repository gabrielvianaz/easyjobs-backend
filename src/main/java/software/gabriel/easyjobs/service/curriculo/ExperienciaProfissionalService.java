/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.curriculo;

import java.util.List;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.curriculo.ExperienciaProfissionalDTO;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.entity.curriculo.ExperienciaProfissional;
import software.gabriel.easyjobs.repository.curriculo.ExperienciaProfissionalRepository;
import software.gabriel.easyjobs.service.base.curriculo.AbstractCampoCurriculoManyToOneService;

/**
 *
 * @author gabriel
 */
@Service
public class ExperienciaProfissionalService
        extends AbstractCampoCurriculoManyToOneService<ExperienciaProfissional, ExperienciaProfissionalDTO, ExperienciaProfissionalRepository> {

    public ExperienciaProfissionalService() {
        super(ExperienciaProfissional.class);
    }

    public void cadastrar(List<ExperienciaProfissionalDTO> experienciasProfissionaisDTO) {
        Curriculo curriculo = getCurriculoCandidatoAutenticado();
        cadastrar(experienciasProfissionaisDTO, curriculo, curriculo.getExperienciasProfissionais());
    }

    protected ExperienciaProfissional aplicarDTO(ExperienciaProfissional experienciaProfissional, ExperienciaProfissionalDTO experienciaProfissionalDTO) {
        experienciaProfissional.setFuncao(experienciaProfissionalDTO.getFuncao());
        experienciaProfissional.setEmpresa(experienciaProfissionalDTO.getEmpresa());
        experienciaProfissional.setEmpregoAtual(experienciaProfissionalDTO.getEmpregoAtual());
        experienciaProfissional.setMesInicio(experienciaProfissionalDTO.getMesInicio());
        experienciaProfissional.setAnoInicio(experienciaProfissionalDTO.getAnoInicio());
        experienciaProfissional.setMesSaida(experienciaProfissionalDTO.getMesSaida());
        experienciaProfissional.setAnoSaida(experienciaProfissionalDTO.getAnoSaida());
        experienciaProfissional.setDescricao(experienciaProfissionalDTO.getDescricao());
        return experienciaProfissional;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.curriculo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculo;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculoManyToOne;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.mapper.curriculo.CampoCurriculoMapper;

/**
 *
 * @author gabriel
 */
@Service
public class CampoCurriculoHelperService {

    @Autowired
    private CurriculoService curriculoService;

    @Autowired
    private CampoCurriculoMapper campoCurriculoMapper;

    public <T extends AbstractCampoCurriculo, S extends CampoCurriculoDTO> T mapToEntity(S dto) {
        return (T) campoCurriculoMapper.toEntity(dto);
    }

    public <T extends CampoCurriculoDTO, S extends AbstractCampoCurriculo> T mapToDTO(S entity) {
        return (T) campoCurriculoMapper.toDTO(entity);
    }

    public Curriculo getCurriculoCandidatoAutenticado() {
        return curriculoService.findByCandidatoUsuarioAutenticado();
    }

    public <T extends AbstractCampoCurriculoManyToOne> List<T> setCurriculoAndFilter(List<? extends CampoCurriculoDTO> listaDTO, Curriculo curriculo, List<T> listaCurriculoCampoCurriculo) {
        return listaDTO.stream()
                .map(campoCurriculoDTO -> {
                    T campoCurriculo = (T) campoCurriculoMapper.toEntity(campoCurriculoDTO);
                    campoCurriculo.setCurriculo(curriculo);
                    return campoCurriculo;
                })
                .filter(campoCurriculo -> !listaCurriculoCampoCurriculo.contains(campoCurriculo))
                .toList();
    }
}

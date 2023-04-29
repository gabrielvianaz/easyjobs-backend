/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.base.curriculo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.dto.base.AbstractDTO;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculo;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculoManyToOne;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.service.base.AbstractNamedEntityService;
import software.gabriel.easyjobs.service.curriculo.CampoCurriculoHelperService;

/**
 *
 * @author gabriel
 */
public abstract class AbstractCampoCurriculoService<T extends AbstractCampoCurriculo, R extends AbstractDTO<T>, S extends JpaRepository<T, Long>>
        extends AbstractNamedEntityService<T, R, S> {

    @Autowired
    private CampoCurriculoHelperService campoCurriculoHelperService;

    public AbstractCampoCurriculoService(Class<T> classe) {
        super(classe);
    }

    protected <T extends AbstractCampoCurriculo, S extends CampoCurriculoDTO> T mapToEntity(S dto) {
        return campoCurriculoHelperService.mapToEntity(dto);
    }

    protected <T extends CampoCurriculoDTO, S extends AbstractCampoCurriculo> T mapToDTO(S entity) {
        return campoCurriculoHelperService.mapToDTO(entity);
    }
    
    public <T extends AbstractCampoCurriculoManyToOne> List<T> setCurriculoAndFilter(List<? extends CampoCurriculoDTO> listaDTO, Curriculo curriculo, List<T> listaCurriculoCampoCurriculo) {
        return campoCurriculoHelperService.setCurriculoAndFilter(listaDTO, curriculo, listaCurriculoCampoCurriculo);
    }

    protected Curriculo getCurriculoCandidatoAutenticado() {
        return campoCurriculoHelperService.getCurriculoCandidatoAutenticado();
    }

}

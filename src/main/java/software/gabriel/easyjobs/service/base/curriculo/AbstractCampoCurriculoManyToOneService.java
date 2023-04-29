/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.base.curriculo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.dto.base.curriculo.CampoCurriculoDTO;
import software.gabriel.easyjobs.entity.base.curriculo.AbstractCampoCurriculoManyToOne;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.exception.global.EntidadeOutroUsuarioException;

/**
 *
 * @author gabriel
 */
public abstract class AbstractCampoCurriculoManyToOneService<T extends AbstractCampoCurriculoManyToOne, R extends CampoCurriculoDTO<T>, S extends JpaRepository<T, Long>>
        extends AbstractCampoCurriculoService<T, R, S> {

    public AbstractCampoCurriculoManyToOneService(Class<T> classe) {
        super(classe);
    }
    
    public abstract void cadastrar(List<R> listaCampoCurriculoDTO);

    public void cadastrar(List<R> listaCampoCurriculoDTO, Curriculo curriculo, List<T> listaCurriculoCampoCurriculo) {
        List<T> listaCampoCurriculo = setCurriculoAndFilter(listaCampoCurriculoDTO, curriculo, listaCurriculoCampoCurriculo);
        salvar(listaCampoCurriculo);
    }

    @Override
    public void deletar(Long id) {
        validarCandidato(findByIdOrElseThrow(id));
        super.deletar(id);
    }

    public void alterar(Long id, R dto) {
        T campoCurriculo = findByIdOrElseThrow(id);
        validarCandidato(campoCurriculo);
        super.alterar(aplicarDTO(campoCurriculo, dto));
    }

    private void validarCandidato(T campoCurriculo) {
        if (!campoCurriculo.getCurriculo().getCandidato().equals(getCurriculoCandidatoAutenticado().getCandidato())) {
            throw new EntidadeOutroUsuarioException(entity.getClass());
        }
    }

}

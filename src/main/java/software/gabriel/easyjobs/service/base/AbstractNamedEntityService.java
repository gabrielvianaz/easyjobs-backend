/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.base;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.dto.base.AbstractDTO;
import software.gabriel.easyjobs.entity.base.AbstractNamedEntity;
import software.gabriel.easyjobs.exception.global.IdNaoLocalizadoException;

/**
 *
 * @author gabriel
 */
public abstract class AbstractNamedEntityService<T extends AbstractNamedEntity, R extends AbstractDTO<T>, S extends JpaRepository<T, Long>>
        extends AbstractEntityService<T, R, S> {

    public AbstractNamedEntityService(Class<T> classe) {
        super(classe);
    }

    public T findByIdOrElseThrow(Long id) {
        return repository.findById(id).orElseThrow(() -> new IdNaoLocalizadoException(entity.getClass()));
    }

}

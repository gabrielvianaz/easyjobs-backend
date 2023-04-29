/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.base;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.dto.base.AbstractDTO;
import software.gabriel.easyjobs.entity.base.AbstractEntity;

/**
 *
 * @author gabriel
 */
public abstract class AbstractEntityService<T extends AbstractEntity, R extends AbstractDTO<T>, S extends JpaRepository<T, Long>> {

    protected T entity;

    @Autowired
    protected S repository;

    public AbstractEntityService(Class<T> classe) {
        try {
            this.entity = classe.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException("Erro ao instanciar entidade!");
        }
    }

    public void salvar(T entity) {
        repository.save(entity);
    }

    public void salvar(List<T> entityList) {
        repository.saveAll(entityList);
    }

    public void alterar(T entity) {
        salvar(entity);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    protected abstract T aplicarDTO(T entity, R dto);

}

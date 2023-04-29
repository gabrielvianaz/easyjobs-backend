/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.entity.base;

import jakarta.persistence.MappedSuperclass;
import software.gabriel.easyjobs.model.base.NamedEntityModel;

/**
 *
 * @author gabriel
 */
@MappedSuperclass
public abstract class AbstractNamedEntity
        extends AbstractEntity
        implements NamedEntityModel {

    @Override
    public abstract String getEntityName();

}

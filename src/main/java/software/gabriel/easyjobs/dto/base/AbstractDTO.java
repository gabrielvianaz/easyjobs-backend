/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.dto.base;

import java.io.Serializable;
import software.gabriel.easyjobs.entity.base.AbstractEntity;

/**
 *
 * @author gabriel
 */
public abstract class AbstractDTO<T extends AbstractEntity>
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

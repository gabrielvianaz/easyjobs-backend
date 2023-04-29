/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper.base;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;
import software.gabriel.easyjobs.dto.base.AbstractDTO;
import software.gabriel.easyjobs.entity.base.AbstractEntity;

/**
 *
 * @author gabriel
 */
@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DefaultMapper<T extends AbstractEntity, R extends AbstractDTO<T>> {

    T toEntity(R dto);

    R toDTO(T entity);

}

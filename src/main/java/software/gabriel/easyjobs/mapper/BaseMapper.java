/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;
import software.gabriel.easyjobs.dto.BaseDTO;
import software.gabriel.easyjobs.entity.BaseEntity;

/**
 *
 * @author gabriel
 */
@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseMapper<T extends BaseEntity, R extends BaseDTO<T>> {

    T toEntity(R dto);

    R toDTO(T entity);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper;

import org.mapstruct.Mapper;
import software.gabriel.easyjobs.dto.EmpresaDTO;
import software.gabriel.easyjobs.entity.Empresa;

/**
 *
 * @author gabriel
 */
@Mapper(config = BaseMapper.class)
public interface EmpresaMapper
        extends BaseMapper<Empresa, EmpresaDTO> {

}

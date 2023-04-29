/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper.empresa;

import org.mapstruct.Mapper;
import software.gabriel.easyjobs.dto.empresa.EmpresaDTO;
import software.gabriel.easyjobs.entity.empresa.Empresa;
import software.gabriel.easyjobs.mapper.base.DefaultMapper;

/**
 *
 * @author gabriel
 */
@Mapper(config = DefaultMapper.class)
public interface EmpresaMapper
        extends DefaultMapper<Empresa, EmpresaDTO> {

}

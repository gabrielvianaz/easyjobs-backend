/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import software.gabriel.easyjobs.dto.UsuarioDTO;
import software.gabriel.easyjobs.entity.Usuario;

/**
 *
 * @author gabriel
 */
@Mapper(config = BaseMapper.class)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

    @Override
    @Mapping(target = "senha", ignore = true)
    public UsuarioDTO toDTO(Usuario entity);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper.security;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import software.gabriel.easyjobs.dto.security.UsuarioDTO;
import software.gabriel.easyjobs.entity.security.Usuario;
import software.gabriel.easyjobs.mapper.base.DefaultMapper;

/**
 *
 * @author gabriel
 */
@Mapper(config = DefaultMapper.class)
public interface UsuarioMapper extends DefaultMapper<Usuario, UsuarioDTO> {

    @Override
    @Mapping(target = "senha", ignore = true)
    public UsuarioDTO toDTO(Usuario entity);

}

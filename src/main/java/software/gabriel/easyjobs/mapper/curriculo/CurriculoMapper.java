/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper.curriculo;

import org.mapstruct.Mapper;
import software.gabriel.easyjobs.dto.curriculo.CurriculoDTO;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.mapper.base.DefaultMapper;

/**
 *
 * @author gabriel
 */
@Mapper(config = DefaultMapper.class, uses = {CampoCurriculoMapper.class})
public interface CurriculoMapper
        extends DefaultMapper<Curriculo, CurriculoDTO> {

}

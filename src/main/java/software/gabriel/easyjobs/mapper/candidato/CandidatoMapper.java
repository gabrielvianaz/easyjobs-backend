/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.mapper.candidato;

import org.mapstruct.Mapper;
import software.gabriel.easyjobs.dto.candidato.CandidatoDTO;
import software.gabriel.easyjobs.entity.candidato.Candidato;
import software.gabriel.easyjobs.mapper.base.DefaultMapper;

/**
 *
 * @author gabriel
 */
@Mapper(config = DefaultMapper.class)
public interface CandidatoMapper
        extends DefaultMapper<Candidato, CandidatoDTO> {

}

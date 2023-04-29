/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.curriculo;

import java.util.List;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.curriculo.IdiomaDTO;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.entity.curriculo.Idioma;
import software.gabriel.easyjobs.repository.curriculo.IdiomaRepository;
import software.gabriel.easyjobs.service.base.curriculo.AbstractCampoCurriculoManyToOneService;

/**
 *
 * @author gabriel
 */
@Service
public class IdiomaService
        extends AbstractCampoCurriculoManyToOneService<Idioma, IdiomaDTO, IdiomaRepository> {

    public IdiomaService() {
        super(Idioma.class);
    }

    public void cadastrar(List<IdiomaDTO> idiomasDTO) {
        Curriculo curriculo = getCurriculoCandidatoAutenticado();
        cadastrar(idiomasDTO, curriculo, curriculo.getIdiomas());
    }

    @Override
    protected Idioma aplicarDTO(Idioma idioma, IdiomaDTO idiomaDTO) {
        idioma.setNome(idiomaDTO.getNome());
        idioma.setNivel(idiomaDTO.getNivel());
        return idioma;
    }

}

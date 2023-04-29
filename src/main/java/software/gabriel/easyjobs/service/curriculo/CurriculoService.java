/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.curriculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.entity.candidato.Candidato;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.repository.curriculo.CurriculoRepository;
import software.gabriel.easyjobs.service.candidato.CandidatoService;

/**
 *
 * @author gabriel
 */
@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;
    
    @Autowired
    private CandidatoService candidatoService;

    public void cadastrar(Candidato candidato) {
        curriculoRepository.save(new Curriculo(candidato));
    }
    
    public Curriculo findByCandidatoUsuarioAutenticado() {
        return curriculoRepository.findByCandidato(candidatoService.findByUsuarioAutenticado());
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.repository.curriculo;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.entity.candidato.Candidato;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;

/**
 *
 * @author gabriel
 */
public interface CurriculoRepository
        extends JpaRepository<Curriculo, Long> {
    
    Curriculo findByCandidato(Candidato candidato);

}

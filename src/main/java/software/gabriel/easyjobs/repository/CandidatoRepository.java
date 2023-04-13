/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.entity.Candidato;

/**
 *
 * @author gabriel
 */
public interface CandidatoRepository
        extends JpaRepository<Candidato, Long> {

}

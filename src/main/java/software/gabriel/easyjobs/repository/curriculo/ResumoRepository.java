/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.repository.curriculo;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.entity.curriculo.Resumo;

/**
 *
 * @author gabriel
 */
public interface ResumoRepository
        extends JpaRepository<Resumo, Long> {
    
    Resumo findByCurriculo(Curriculo curriculo);

}

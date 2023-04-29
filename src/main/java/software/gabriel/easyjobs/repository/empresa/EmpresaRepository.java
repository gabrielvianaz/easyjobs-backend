/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.repository.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.entity.empresa.Empresa;
import software.gabriel.easyjobs.entity.security.Usuario;

/**
 *
 * @author gabriel
 */
public interface EmpresaRepository
        extends JpaRepository<Empresa, Long> {
    
    Empresa findByUsuario(Usuario usuario);

}

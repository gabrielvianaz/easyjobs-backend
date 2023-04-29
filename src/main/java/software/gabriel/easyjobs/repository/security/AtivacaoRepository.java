/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.entity.security.Ativacao;
import software.gabriel.easyjobs.entity.security.Usuario;

/**
 *
 * @author gabriel
 */
public interface AtivacaoRepository
        extends JpaRepository<Ativacao, Long> {

    Ativacao findByUsuario(Usuario usuario);

}

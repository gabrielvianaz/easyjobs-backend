/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.easyjobs.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.easyjobs.entity.security.Role;

/**
 *
 * @author gabriel
 */
public interface RoleRepository
        extends JpaRepository<Role, Long> {

    Role findByName(String name);

}

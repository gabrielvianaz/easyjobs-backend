/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.entity.security.Role;
import software.gabriel.easyjobs.repository.security.RoleRepository;

/**
 *
 * @author gabriel
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.security;

import software.gabriel.easyjobs.utils.SecurityUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.entity.security.Usuario;

/**
 *
 * @author gabriel
 */
@Service
public class TokenService {
    
    public String gerar(Usuario usuario) {
        return JWT.create()
                .withIssuer("EasyJobs")
                .withSubject(usuario.getEmail())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(SecurityUtils.getJwtSecret()));
    }
    
    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(SecurityUtils.getJwtSecret()))
                .withIssuer("EasyJobs")
                .build()
                .verify(token)
                .getSubject();
    }
    
}

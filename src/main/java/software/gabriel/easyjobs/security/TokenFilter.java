/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import software.gabriel.easyjobs.entity.Usuario;
import software.gabriel.easyjobs.repository.UsuarioRepository;

/**
 *
 * @author gabriel
 */
@Component
public class TokenFilter
        extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {        
        String token;        
        String authorizationHeader = request.getHeader("Authorization");                
        
        if (authorizationHeader != null) {
            token = authorizationHeader.replace("Bearer ", "");            
            String subject = tokenService.getSubject(token);            
            Usuario usuario = usuarioRepository.findByEmail(subject);
            
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,
                    null, usuario.getAuthorities());
            
            SecurityContextHolder.getContext().setAuthentication(authentication);                        
        }
        
        filterChain.doFilter(request, response);        
    }

}

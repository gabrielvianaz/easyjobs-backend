/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.security.UsuarioDTO;
import software.gabriel.easyjobs.entity.security.Usuario;
import software.gabriel.easyjobs.exception.security.ContaNaoAtivadaException;
import software.gabriel.easyjobs.exception.security.SenhaIncorretaException;
import software.gabriel.easyjobs.exception.security.EmailNaoCadastradoException;
import software.gabriel.easyjobs.service.security.TokenService;

/**
 *
 * @author gabriel
 */
@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String getToken(UsuarioDTO usuarioDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha());
        try {
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            Usuario usuario = (Usuario) authentication.getPrincipal();
            return tokenService.gerar(usuario);
        } catch (DisabledException e) {
            throw new ContaNaoAtivadaException();
        } catch (BadCredentialsException e) {
            throw new SenhaIncorretaException();
        } catch (AuthenticationException e) {
            throw new EmailNaoCadastradoException();
        }

    }
}

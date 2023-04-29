/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.controller.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.easyjobs.dto.security.UsuarioDTO;
import software.gabriel.easyjobs.utils.SecurityUtils;
import software.gabriel.easyjobs.service.security.LoginService;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody @Valid UsuarioDTO usuarioDTO, HttpServletResponse response) {
        String token = loginService.getToken(usuarioDTO);
        Cookie cookie = getCookie(token);
        response.addCookie(cookie);
        return ResponseEntity.ok().build();
    }

    private Cookie getCookie(String token) {
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(SecurityUtils.SEGUNDOS_EXPIRACAO_TOKEN_JWT);
        cookie.setPath("/");
        cookie.setSecure(true);
        return cookie;
    }

}

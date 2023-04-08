/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.controller;

import jakarta.servlet.http.Cookie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.easyjobs.dto.UsuarioDTO;
import software.gabriel.easyjobs.service.LoginService;

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
    public ResponseEntity<Void> login(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        String token = loginService.getToken(usuarioDTO);
        return ResponseEntity.ok().headers(getHeader(token)).build();
    }

    private Cookie getCookie(String token) {
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(86400);
        cookie.setPath("/");
        cookie.setSecure(true);
        return cookie;
    }

    private HttpHeaders getHeader(String token) {
        Cookie cookie = getCookie(token);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.SET_COOKIE, cookie.getName() + "=" + cookie.getValue());
        return header;
    }

}

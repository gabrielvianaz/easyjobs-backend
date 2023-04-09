/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.security;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class SecurityUtils {

    public static String getJwtSecret() {
        return System.getenv("JWT_SECRET");
    }

    public static List<String> getAllowedOrigins() {
        return Arrays.asList("http://localhost:5173");
    }

    public static Integer SEGUNDOS_EXPIRACAO_TOKEN_JWT = 86400;

}

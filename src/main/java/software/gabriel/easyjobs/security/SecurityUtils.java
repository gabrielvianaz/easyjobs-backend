/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.security;

/**
 *
 * @author gabriel
 */
public class SecurityUtils {
    
    public static String getJwtSecret() {
        return System.getenv("JWT_SECRET");
    }
    
}

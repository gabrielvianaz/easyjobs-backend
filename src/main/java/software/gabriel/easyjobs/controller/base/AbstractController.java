/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import software.gabriel.easyjobs.service.base.AbstractEntityService;

/**
 *
 * @author gabriel
 */
public abstract class AbstractController<T extends AbstractEntityService> {

    @Autowired
    protected T service;

}

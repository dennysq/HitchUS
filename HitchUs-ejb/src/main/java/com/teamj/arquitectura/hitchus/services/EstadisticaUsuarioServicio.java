/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.EstadisticaUsuarioDAO;
import com.teamj.arquitectura.hitchus.model.EstadisticaUsuario;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author LENOVO
 */

@Stateless
@LocalBean
public class EstadisticaUsuarioServicio {
    
        @EJB
    EstadisticaUsuarioDAO estadisticaUsuarioDAO;
    
    public EstadisticaUsuario getEstadisticaUsuario(Integer id){
        
        return estadisticaUsuarioDAO.findById(id, true);
        
    }
}

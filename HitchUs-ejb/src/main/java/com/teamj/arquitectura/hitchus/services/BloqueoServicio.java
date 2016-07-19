/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.BloqueoDAO;
import com.teamj.arquitectura.hitchus.dao.UsuarioDAO;
import com.teamj.arquitectura.hitchus.model.Bloqueo;
import static com.teamj.arquitectura.hitchus.model.BloqueoPK_.usuario1;
import com.teamj.arquitectura.hitchus.model.Usuario;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author LENOVO
 */

@Stateless
@LocalBean
public class BloqueoServicio {
    
    @EJB
    BloqueoDAO bloqueoDAO;
    
    @EJB
    UsuarioDAO usuarioDAO;
    
    public void bloquearUsuario(Integer id_u1, Integer id_u2){
        Date  fecha = new Date();
        Bloqueo bloq = new Bloqueo();
        Usuario us1 = new Usuario();
        Usuario us2 = new Usuario();
        us1 = usuarioDAO.findById(id_u1, true);
        us2 = usuarioDAO.findById(id_u2, true);
        bloq.setUsuario1(us1);
        bloq.setUsuario2(us2);
        bloq.setDate(fecha);
        bloqueoDAO.insert(bloq);
    }
            
    
}

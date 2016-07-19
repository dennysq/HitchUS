/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.BloqueoDAO;
import com.teamj.arquitectura.hitchus.dao.UsuarioDAO;
import com.teamj.arquitectura.hitchus.model.Bloqueo;
import com.teamj.arquitectura.hitchus.model.BloqueoPK;
import java.util.Calendar;
import java.util.TimeZone;
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

    public void bloquearUsuario(Integer id_u1, Integer id_u2) {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("ECT"));
        Bloqueo bloq = new Bloqueo();
        BloqueoPK bloqueoPK=new BloqueoPK();
        bloqueoPK.setUsuario1(id_u1);
        bloqueoPK.setUsuario2(id_u2);
        bloq.setBloqueoPK(bloqueoPK);
        
        bloq.setFecha(c.getTime());
        bloqueoDAO.insert(bloq);
    }

}

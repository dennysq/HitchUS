/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.hitchus.model.CalificacionEncuentro;
import com.teamj.arquitectura.hitchus.model.CalificacionEncuentroPK;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class CalificacionEncuentroDAO extends DefaultGenericDAOImple<CalificacionEncuentro, CalificacionEncuentroPK> {
    public CalificacionEncuentroDAO() {
            super(CalificacionEncuentro.class);
        }
}

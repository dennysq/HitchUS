/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.hitchus.model.Bloqueo;
import com.teamj.arquitectura.hitchus.model.BloqueoPK;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class BloqueoDAO extends DefaultGenericDAOImple<Bloqueo, BloqueoPK> {
    public BloqueoDAO() {
            super(Bloqueo.class);
        }
}

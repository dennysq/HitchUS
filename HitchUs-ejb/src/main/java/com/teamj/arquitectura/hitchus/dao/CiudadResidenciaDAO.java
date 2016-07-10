/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.hitchus.model.CiudadResidencia;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class CiudadResidenciaDAO extends DefaultGenericDAOImple<CiudadResidencia, Integer>{
    public CiudadResidenciaDAO() {
        super(CiudadResidencia.class);
    }
}

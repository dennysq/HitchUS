/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class TipoCertificadoDAO extends DefaultGenericDAOImple<TipoCertificado, Integer>{
    public TipoCertificadoDAO() {
        super(TipoCertificado.class);
    }
}

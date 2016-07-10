/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.hitchus.model.EntidadCertificadora;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class EntidadCertificadoraDAO extends DefaultGenericDAOImple<EntidadCertificadora, Integer>{
    public EntidadCertificadoraDAO() {
        super(EntidadCertificadora.class);
    }
}

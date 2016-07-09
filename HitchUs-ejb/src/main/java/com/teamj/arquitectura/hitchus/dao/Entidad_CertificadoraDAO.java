/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.hitchus.model.Entidad_Certificadora;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class Entidad_CertificadoraDAO extends DefaultGenericDAOImple<Entidad_Certificadora, Integer>{
    public Entidad_CertificadoraDAO() {
        super(Entidad_Certificadora.class);
    }
}

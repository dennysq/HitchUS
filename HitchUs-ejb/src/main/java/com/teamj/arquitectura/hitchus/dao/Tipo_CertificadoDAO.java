/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.hitchus.model.Tipo_Certificado;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class Tipo_CertificadoDAO extends DefaultGenericDAOImple<Tipo_Certificado, Integer>{
    public Tipo_CertificadoDAO() {
        super(Tipo_Certificado.class);
    }
}

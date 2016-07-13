/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.CertificadoDAO;
import com.teamj.arquitectura.hitchus.dao.EntidadCertificadoraDAO;
import com.teamj.arquitectura.hitchus.dao.TipoCertificadoDAO;
import com.teamj.arquitectura.hitchus.model.Certificado;
import com.teamj.arquitectura.hitchus.model.CertificadoPK;
import com.teamj.arquitectura.hitchus.model.EntidadCertificadora;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import com.teamj.arquitectura.hitchus.model.Usuario;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Dennys
 */
@Stateless
@LocalBean
public class CertificadoServicio {

    @EJB
    private CertificadoDAO certificadoDAO;

    @EJB
    private TipoCertificadoDAO tipoCertificadoDAO;
    @EJB
    private EntidadCertificadoraDAO entidadCertificadoraDAO;

    public List<Certificado> obtenerCertificadosPorUsuario(Usuario u) {
        Certificado c = new Certificado();
        c.setUsuario(u);
        return certificadoDAO.find(c);
    }

    

    public List<TipoCertificado> obtenerTiposDeCertificado() {
        return tipoCertificadoDAO.findAll();
    }
}

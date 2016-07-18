/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.listener;

import com.teamj.arquitectura.hitchus.dao.CiudadResidenciaDAO;
import com.teamj.arquitectura.hitchus.dao.EntidadCertificadoraDAO;
import com.teamj.arquitectura.hitchus.dao.PaisOrigenDAO;
import com.teamj.arquitectura.hitchus.dao.TipoCertificadoDAO;
import com.teamj.arquitectura.hitchus.model.CiudadResidencia;
import com.teamj.arquitectura.hitchus.model.EntidadCertificadora;
import com.teamj.arquitectura.hitchus.model.PaisOrigen;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author martin
 */
@WebListener
public class ApplicationServletContext implements ServletContextListener {

    @EJB
    TipoCertificadoDAO tipoCertificadoDAO;
    @EJB
    EntidadCertificadoraDAO entidadCertificadoraDAO;
    @EJB
    CiudadResidenciaDAO ciudadResidenciaDAO;
    @EJB
    PaisOrigenDAO paisOrigenDAO;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Starting up!");
        List<TipoCertificado> tipoCertificadoList = tipoCertificadoDAO.findAll();
        if (tipoCertificadoList.isEmpty()) {
            TipoCertificado sida = new TipoCertificado();
            sida.setDescripcion("Certificado para verificar si la persona adquiriente está infectada con dicha enfermedad");
            sida.setNombreCertificado("Certificado de SIDA");
            sida.setNombreEnfermedad("VIH SIDA");
            sida.setTiempoValidez(12);
            TipoCertificado gonorrea = new TipoCertificado();
            gonorrea.setDescripcion("Certificado para verificar si la persona adquiriente está infectada con dicha enfermedad");
            gonorrea.setNombreCertificado("Certificado de Gonorrea");
            gonorrea.setNombreEnfermedad("Gonorrea");
            gonorrea.setTiempoValidez(24);
            TipoCertificado herpes = new TipoCertificado();
            herpes.setDescripcion("Certificado para verificar si la persona adquiriente está infectada con dicha enfermedad");
            herpes.setNombreCertificado("Certificado de Herpes");
            herpes.setNombreEnfermedad("Herpes");
            herpes.setTiempoValidez(12);
            TipoCertificado sifilis = new TipoCertificado();
            sifilis.setDescripcion("Certificado para verificar si la persona adquiriente está infectada con dicha enfermedad");
            sifilis.setNombreCertificado("Certificado de Sífilis");
            sifilis.setNombreEnfermedad("Sífilis");
            sifilis.setTiempoValidez(24);
            TipoCertificado clamidia = new TipoCertificado();
            clamidia.setDescripcion("Certificado para verificar si la persona adquiriente está infectada con dicha enfermedad");
            clamidia.setNombreCertificado("Certificado de Clamidia");
            clamidia.setNombreEnfermedad("Clamidia");
            clamidia.setTiempoValidez(24);
            TipoCertificado tricomoniasis = new TipoCertificado();
            tricomoniasis.setDescripcion("Certificado para verificar si la persona adquiriente está infectada con dicha enfermedad");
            tricomoniasis.setNombreCertificado("Certificado de Tricomoniasis");
            tricomoniasis.setNombreEnfermedad("Tricomoniasis");
            tricomoniasis.setTiempoValidez(12);

            tipoCertificadoDAO.insert(sida);
            tipoCertificadoDAO.insert(clamidia);
            tipoCertificadoDAO.insert(tricomoniasis);
            tipoCertificadoDAO.insert(sifilis);
            tipoCertificadoDAO.insert(herpes);
            tipoCertificadoDAO.insert(gonorrea);

        }
        if (entidadCertificadoraDAO.findAll().isEmpty()) {
            EntidadCertificadora entidadCertificadora = new EntidadCertificadora();
            entidadCertificadora.setDireccion("Universidad de las Fuerzas Armadas ESPE");
            entidadCertificadora.setNombre("HitchUS");
            entidadCertificadora.setTelefono("127823122112");
            entidadCertificadoraDAO.insert(entidadCertificadora);

        }
        if (ciudadResidenciaDAO.findAll().isEmpty()) {
            CiudadResidencia ciudadResidencia = new CiudadResidencia();
            ciudadResidencia.setNombre("Quito");
            ciudadResidenciaDAO.insert(ciudadResidencia);
            ciudadResidencia = new CiudadResidencia();
            ciudadResidencia.setNombre("Guayaquil");
            ciudadResidenciaDAO.insert(ciudadResidencia);

        }
        if (paisOrigenDAO.findAll().isEmpty()) {
            PaisOrigen paisOrigen = new PaisOrigen();
            paisOrigen.setNombre("Ecuador");
            paisOrigenDAO.insert(paisOrigen);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }

}

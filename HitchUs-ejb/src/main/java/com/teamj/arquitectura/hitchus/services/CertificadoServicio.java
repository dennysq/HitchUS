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
import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import com.teamj.arquitectura.hitchus.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Dennys
 */
@Stateless
@LocalBean
public class CertificadoServicio implements Serializable {

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

    public void guardarArchivo(InputStream input, String path, String name, Certificado certificado) {
        certificado.setPath(path);
        certificado.setNombreArchivo(String.valueOf(certificado.getUsuario().getId())+name);
        certificado.setFechaRecepcion(Calendar.getInstance(TimeZone.getTimeZone("ECT")).getTime());
        //create destination File

        //use org.apache.commons.io.FileUtils to copy the File
        try {
            this.certificadoDAO.update(certificado);
            File destFile = new File(certificado.getPath(), certificado.getNombreArchivo() + ".pdf");
            FileUtils.copyInputStreamToFile(input, destFile);

        } catch (IOException e) {
            //log error
            System.out.println("" + e);
        }
    }

    public List<TipoCertificado> obtenerTiposDeCertificado() {
        return tipoCertificadoDAO.findAll();
    }
}

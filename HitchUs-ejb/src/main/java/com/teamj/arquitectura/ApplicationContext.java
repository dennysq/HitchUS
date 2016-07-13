/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura;

import com.teamj.arquitectura.hitchus.dao.CiudadResidenciaDAO;
import com.teamj.arquitectura.hitchus.dao.EntidadCertificadoraDAO;
import com.teamj.arquitectura.hitchus.dao.PaisOrigenDAO;
import com.teamj.arquitectura.hitchus.dao.TipoCertificadoDAO;
import com.teamj.arquitectura.hitchus.model.CiudadResidencia;
import com.teamj.arquitectura.hitchus.model.EntidadCertificadora;
import com.teamj.arquitectura.hitchus.model.PaisOrigen;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import com.teamj.arquitectura.hitchus.util.Pais;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author martin
 */
@Startup
@Singleton
public class ApplicationContext {

    private final String imagesPath = "C:\\hitchus";
    private List<Pais> paises;
    private Map<String, String> genero;
    private Map<String, String> nivelDeEducacion;
    private Map<String, String> siNo;
    @EJB
    TipoCertificadoDAO tipoCertificadoDAO;
    @EJB
    EntidadCertificadoraDAO entidadCertificadoraDAO;
    @EJB
    CiudadResidenciaDAO ciudadResidenciaDAO;
    @EJB
    PaisOrigenDAO paisOrigenDAO;

    @PostConstruct
    public void init() {
        paises = new ArrayList<>();
        genero = new HashMap<>();
        genero.put("MAS", "Masculino");
        genero.put("FEM", "Femenino");
        genero.put("OTR", "Otro");
        System.out.println("Iniciando contexto");
        nivelDeEducacion = new HashMap<>();
        nivelDeEducacion.put("PRI", "Primaria");
        nivelDeEducacion.put("BAC", "Bachillerato");
        nivelDeEducacion.put("TER", "Tercer Nivel");
        nivelDeEducacion.put("CUA", "Cuarto Nivel");
        siNo = new HashMap<>();
        siNo.put("S", "SI");
        siNo.put("N", "NO");
        InputStream csvFile = ApplicationContext.class.getClassLoader().getResourceAsStream("paises.csv");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new InputStreamReader(csvFile));
            Pais pais;
            while ((line = br.readLine()) != null) {
                pais = new Pais();

                // use comma as separator
                String[] field = line.split(cvsSplitBy);
                if (field != null && field.length >= 6) {
                    pais.setNombre(field[0]);
                    pais.setNombreIngles(field[1]);
                    pais.setNombreFrances(field[2]);
                    pais.setIso2(field[3]);
                    pais.setIso3(field[4]);
                    pais.setCodigoTelefónico(field[5]);
                    this.paises.add(pais);
                }

            }

            System.out.println("Done");
        } catch (IOException ex) {
            Logger.getLogger(ApplicationContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    Logger.getLogger(ApplicationContext.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
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

// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")
    public List<Pais> getPaises() {
        return paises;
    }

     

    public String getImagesPath() {
        return imagesPath;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public Map<String, String> getGenero() {
        return genero;
    }

    public void setGenero(Map<String, String> genero) {
        this.genero = genero;
    }

    public Map<String, String> getNivelDeEducacion() {
        return nivelDeEducacion;
    }

    public void setNivelDeEducacion(Map<String, String> nivelDeEducacion) {
        this.nivelDeEducacion = nivelDeEducacion;
    }

    public Map<String, String> getSiNo() {
        return siNo;
    }

    public void setSiNo(Map<String, String> siNo) {
        this.siNo = siNo;
    }
}

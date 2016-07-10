/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura;

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
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author martin
 */
@Singleton
@LocalBean
public class ApplicationContext {

    private List<Pais> paises;
    private Map<String, String> genero;
    private Map<String, String> nivelDeEducacion;
    private Map<String, String> siNo;

    @PostConstruct
    public void init() {
        paises = new ArrayList<>();
        genero = new HashMap<>();
        genero.put("MAS", "Masculino");
        genero.put("FEM", "Femenino");
        genero.put("OTR", "Otro");

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

    }

// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")

    public List<Pais> getPaises() {
        return paises;
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

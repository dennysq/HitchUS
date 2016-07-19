/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.util.Pais;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Dennys
 */
@ManagedBean
@ApplicationScoped
public class Constant implements Serializable {

    private final String imagesPath = "C:\\hitchus";
    //private final String imagesPath = "/home/ec2-user/hitchus";
    private List<Pais> paises;
    private Map<String, String> genero;
    private Map<String, String> estado;
    private Map<String, String> premium;
    private Map<String, String> enfermedades;
    private Map<String, String> nivelDeEducacion;
    private Map<String, String> siNo;

    @PostConstruct
    public void init() {
        paises = new ArrayList<>();
        genero = new HashMap<>();
        genero.put("Masculino", "MAS");
        genero.put("Femenino", "FEM");
        genero.put("Otro", "OTR");
        System.out.println("Iniciando contexto");
        nivelDeEducacion = new HashMap<>();
        nivelDeEducacion.put("Primaria", "PRI");
        nivelDeEducacion.put("Bachillerato", "BAC");
        nivelDeEducacion.put("Tercer Nivel", "TER");
        nivelDeEducacion.put("Cuarto Nivel", "CUA");
        premium = new HashMap<>();
        premium.put("Entregado", "E");
        premium.put("Pendiente", "P");
        premium.put("Validado", "V");
        premium.put("No Validado", "N");
        siNo = new HashMap<>();
        siNo.put("Si", "S");
        siNo.put("No", "N");
        estado = new HashMap<>();
        estado.put("Activo", "ACT");
        estado.put("Inactivo", "INA");
        enfermedades=new HashMap<>();
        enfermedades.put("VIH SIDA", "VIH SIDA");
        enfermedades.put("Clamidia", "Clamidia");
        enfermedades.put("Sífilis", "Sífilis");
        enfermedades.put("Herpes", "Herpes");
        enfermedades.put("Tricomoniasis", "Tricomoniasis");
        enfermedades.put("Gonorrea", "Gonorrea");
        
        InputStream csvFile = getClass().getClassLoader().getResourceAsStream("paises.csv");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new InputStreamReader(csvFile));
            Pais pais;
            int i = 0;
            while ((line = br.readLine()) != null) {
                pais = new Pais();
                if (i == 0) {
                    i++;
                    continue;
                }
                i++;
                // use comma as separator
                String[] field = line.split(cvsSplitBy);
                if (field != null && field.length >= 6) {
                    if (field[5].replace("\"", "").isEmpty()) {
                        continue;
                    }
                    pais.setNombre(field[0].replace("\"", ""));
                    pais.setNombreIngles(field[1].replace("\"", ""));
                    pais.setNombreFrances(field[2].replace("\"", ""));
                    pais.setIso2(field[3].replace("\"", ""));
                    pais.setIso3(field[4].replace("\"", ""));
                    pais.setCodigoTelefonico("+" + field[5].replace("\"", ""));
                    this.paises.add(pais);
                }

            }

            System.out.println("Done");
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    }

    public String maxDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -18);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(c.getTime());
    }

    public String maxDateOnlyMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -18);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
        return sdf.format(c.getTime());
    }

    public Map<String, String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Map<String, String> enfermedades) {
        this.enfermedades = enfermedades;
    }
    

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

    public Map<String, String> getEstado() {
        return estado;
    }

    public void setEstado(Map<String, String> estado) {
        this.estado = estado;
    }

    public Map<String, String> getPremium() {
        return premium;
    }

    public void setPremium(Map<String, String> premium) {
        this.premium = premium;
    }

}

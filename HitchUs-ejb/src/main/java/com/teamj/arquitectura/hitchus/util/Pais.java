/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.util;

/**
 *
 * @author Dennys
 */
public class Pais {
    String nombre;
    String nombreIngles;
    String nombreFrances;
    String iso2;
    String iso3;
    String codigoTelefónico;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreIngles() {
        return nombreIngles;
    }

    public void setNombreIngles(String nombreIngles) {
        this.nombreIngles = nombreIngles;
    }

    public String getNombreFrances() {
        return nombreFrances;
    }

    public void setNombreFrances(String nombreFrances) {
        this.nombreFrances = nombreFrances;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getCodigoTelefónico() {
        return codigoTelefónico;
    }

    public void setCodigoTelefónico(String codigoTelefónico) {
        this.codigoTelefónico = codigoTelefónico;
    }

    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", nombreIngles=" + nombreIngles + ", nombreFrances=" + nombreFrances + ", iso2=" + iso2 + ", iso3=" + iso3 + ", codigoTelef\u00f3nico=" + codigoTelefónico + '}';
    }
}

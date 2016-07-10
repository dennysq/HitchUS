/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "TIPO_CERTIFICADO")
public class TipoCertificado implements Serializable{
    
    @Id
    @Column(name = "ID_TIPO_CERTIFICADO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NOMBRE_CERTIFICADO")
    private String nombreCertificado;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "TIEMPO_VALIDEZ")
    private Integer tiempoValidez;
    
    @Column(name = "NOMBRE_ENFERMEDAD")
    private String nombreEnfermedad;

    public TipoCertificado() {
    }

    public TipoCertificado(String nombreCertificado, String descripcion, Integer tiempoValidez, String nombreEnfermedad) {
        this.nombreCertificado = nombreCertificado;
        this.descripcion = descripcion;
        this.tiempoValidez = tiempoValidez;
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCertificado() {
        return nombreCertificado;
    }

    public void setNombreCertificado(String nombreCertificado) {
        this.nombreCertificado = nombreCertificado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTiempoValidez() {
        return tiempoValidez;
    }

    public void setTiempoValidez(Integer tiempoValidez) {
        this.tiempoValidez = tiempoValidez;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoCertificado other = (TipoCertificado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoCertificado{" + "id=" + id + ", nombreCertificado=" + nombreCertificado + ", descripcion=" + descripcion + ", tiempoValidez=" + tiempoValidez + ", nombreEnfermedad=" + nombreEnfermedad + '}';
    }
    
}

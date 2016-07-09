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
public class Tipo_Certificado implements Serializable{
    
    @Id
    @Column(name = "ID_TIPO_CERTIFICADO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NOMBRE_CERTIFICADO")
    private String nombre_certificado;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "TIEMPO_VALIDEZ")
    private Integer tiempo_validez;
    
    @Column(name = "NOMBRE_ENFERMEDAD")
    private String nombre_enfermedad;

    public Tipo_Certificado() {
    }

    public Tipo_Certificado(Integer id, String nombre_certificado, String descripcion, Integer tiempo_validez, String nombre_enfermedad) {
        this.id = id;
        this.nombre_certificado = nombre_certificado;
        this.descripcion = descripcion;
        this.tiempo_validez = tiempo_validez;
        this.nombre_enfermedad = nombre_enfermedad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_certificado() {
        return nombre_certificado;
    }

    public void setNombre_certificado(String nombre_certificado) {
        this.nombre_certificado = nombre_certificado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTiempo_validez() {
        return tiempo_validez;
    }

    public void setTiempo_validez(Integer tiempo_validez) {
        this.tiempo_validez = tiempo_validez;
    }

    public String getNombre_enfermedad() {
        return nombre_enfermedad;
    }

    public void setNombre_enfermedad(String nombre_enfermedad) {
        this.nombre_enfermedad = nombre_enfermedad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Tipo_Certificado other = (Tipo_Certificado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tipo_Certificado{" + "id=" + id + ", nombre_certificado=" + nombre_certificado + ", descripcion=" + descripcion + ", tiempo_validez=" + tiempo_validez + ", nombre_enfermedad=" + nombre_enfermedad + '}';
    }
    
    
    
}

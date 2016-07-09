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
@Table(name = "IMAGEN")
public class Imagen implements Serializable {
    
    @Id
    @Column(name = "ID_IMAGEN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ID_USUARIO")
    private String idUsuario;
     
    @Column(name = "DESCRIPCION")
    private String descripcion;
      
    @Column(name = "PUBLICA")
    private String publica;
    
    @Column(name = "PERFIL")
    private String perfil;
    
    @Column(name = "URL")
    private String url;

    public Imagen() {
    }

    public Imagen(Integer id, String idUsuario, String descripcion, String publica, String perfil, String url) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.publica = publica;
        this.perfil = perfil;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPublica() {
        return publica;
    }

    public void setPublica(String publica) {
        this.publica = publica;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Imagen other = (Imagen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id=" + id + ", idUsuario=" + idUsuario + ", descripcion=" + descripcion + ", publica=" + publica + ", perfil=" + perfil + ", url=" + url + '}';
    }
    
    
    
}

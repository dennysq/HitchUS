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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "IMAGEN")
public class Imagen implements Serializable {
    
    @Id
    @SequenceGenerator(name = "IMAGEN_ID", sequenceName = "IMAGEN_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "IMAGEN_ID")
    @Column(name = "ID_IMAGEN")
    private Integer id;
    
    @Column(name = "ID_USUARIO")
    private Usuario usuario;
     
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return "Imagen{" + "id=" + id + ", usuario=" + usuario + ", descripcion=" + descripcion + ", publica=" + publica + ", perfil=" + perfil + ", url=" + url + '}';
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Klever
 */
@Embeddable
public class CalificacionEncuentroPK implements Serializable{
    
    @Column(name = "ID_ENCUENTRO")
    private Integer encuentro;
     
    @Column(name = "ID_USUARIO")
    private Integer usuario;

    public CalificacionEncuentroPK() {
    }

    public CalificacionEncuentroPK(Integer encuentro, Integer usuario) {
        this.encuentro = encuentro;
        this.usuario = usuario;
    }

    public Integer getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Integer encuentro) {
        this.encuentro = encuentro;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.encuentro);
        hash = 89 * hash + Objects.hashCode(this.usuario);
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
        final CalificacionEncuentroPK other = (CalificacionEncuentroPK) obj;
        if (!Objects.equals(this.encuentro, other.encuentro)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    

}

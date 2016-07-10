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
public class UbicacionPK implements Serializable{
    
    @Column(name = "FECHA")
    private Integer fecha;
     
    @Column(name = "ID_USUARIO")
    private Integer usuario;

    public UbicacionPK() {
    }

    public UbicacionPK(Integer fecha, Integer usuario) {
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
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
        hash = 97 * hash + Objects.hashCode(this.fecha);
        hash = 97 * hash + Objects.hashCode(this.usuario);
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
        final UbicacionPK other = (UbicacionPK) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    
}

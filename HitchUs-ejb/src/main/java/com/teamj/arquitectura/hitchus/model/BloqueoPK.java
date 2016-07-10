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
import javax.persistence.EmbeddedId;

/**
 *
 * @author Klever
 */
@Embeddable
public class BloqueoPK implements Serializable{

    @Column(name = "ID_USUARIO1")
    private Integer usuario1;
     
    @Column(name = "ID_USUARIO2")
    private Integer usuario2;

    public BloqueoPK() {
    }

    public BloqueoPK(Integer usuario1, Integer usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }

    public Integer getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Integer usuario1) {
        this.usuario1 = usuario1;
    }

    public Integer getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Integer usuario2) {
        this.usuario2 = usuario2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.usuario1);
        hash = 83 * hash + Objects.hashCode(this.usuario2);
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
        final BloqueoPK other = (BloqueoPK) obj;
        if (!Objects.equals(this.usuario1, other.usuario1)) {
            return false;
        }
        if (!Objects.equals(this.usuario2, other.usuario2)) {
            return false;
        }
        return true;
    }
    
    

}

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
public class MensajePK implements Serializable{
    @Column(name = "ID_ENC")
    private Integer encuentro;
     
    @Column(name = "SEC_MENSAJE")
    private Integer secMensaje;

    public MensajePK() {
    }

    public MensajePK(Integer encuentro, Integer secMensaje) {
        this.encuentro = encuentro;
        this.secMensaje = secMensaje;
    }

    public Integer getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Integer encuentro) {
        this.encuentro = encuentro;
    }

    public Integer getSecMensaje() {
        return secMensaje;
    }

    public void setSecMensaje(Integer secMensaje) {
        this.secMensaje = secMensaje;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.encuentro);
        hash = 13 * hash + Objects.hashCode(this.secMensaje);
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
        final MensajePK other = (MensajePK) obj;
        if (!Objects.equals(this.encuentro, other.encuentro)) {
            return false;
        }
        if (!Objects.equals(this.secMensaje, other.secMensaje)) {
            return false;
        }
        return true;
    }

}

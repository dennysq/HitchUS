/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "MENSAJE")
public class Mensaje implements Serializable{
    @EmbeddedId
    MensajePK mensajePK;
    
    @ManyToOne
    @JoinColumn(name = "ID_ENC", nullable = false,insertable = false,updatable = false)
    private Encuentro encuentro;
    
    @Column(name = "SEC_MENSAJE")
    private Integer sec_mensaje;
    
    @Column(name = "RECEPTOR")
    private Integer receptor;
    
    @Column(name = "EMISOR")
    private Integer emisor;
    
    @Column(name = "FECHA_ENVIO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_envio;

    public Mensaje() {
    }

    public MensajePK getMensajePK() {
        return mensajePK;
    }

    public void setMensajePK(MensajePK mensajePK) {
        this.mensajePK = mensajePK;
    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public Integer getSec_mensaje() {
        return sec_mensaje;
    }

    public void setSec_mensaje(Integer sec_mensaje) {
        this.sec_mensaje = sec_mensaje;
    }

    public Integer getReceptor() {
        return receptor;
    }

    public void setReceptor(Integer receptor) {
        this.receptor = receptor;
    }

    public Integer getEmisor() {
        return emisor;
    }

    public void setEmisor(Integer emisor) {
        this.emisor = emisor;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.mensajePK);
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
        final Mensaje other = (Mensaje) obj;
        if (!Objects.equals(this.mensajePK, other.mensajePK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "mensajePK=" + mensajePK + ", encuentro=" + encuentro + ", sec_mensaje=" + sec_mensaje + ", receptor=" + receptor + ", emisor=" + emisor + ", fecha_envio=" + fecha_envio + '}';
    }

    
}

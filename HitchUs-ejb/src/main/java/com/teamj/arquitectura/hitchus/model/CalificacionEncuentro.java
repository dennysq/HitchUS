/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "CALIFICACION_ENCUENTRO")
public class CalificacionEncuentro implements Serializable{

    @EmbeddedId
    CalificacionEncuentroPK calificacionEncuentroPK;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false,insertable = false,updatable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "ID_ENCUENTRO", nullable = false,insertable = false,updatable = false)
    private Encuentro encuentro;       
        
    @Column(name = "HIGIENE")
    private BigDecimal higiene;
    
    @Column(name = "COMPORTAMIENTO")
    private BigDecimal comportamiento;
    
    @Column(name = "AMABILIDAD")
    private BigDecimal amabilidad;
    
    @Column(name = "GENERAL")
    private BigDecimal general;

    public CalificacionEncuentro() {
    }

    public CalificacionEncuentroPK getCalificacionEncuentroPK() {
        return calificacionEncuentroPK;
    }

    public void setCalificacionEncuentroPK(CalificacionEncuentroPK calificacionEncuentroPK) {
        this.calificacionEncuentroPK = calificacionEncuentroPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public BigDecimal getHigiene() {
        return higiene;
    }

    public void setHigiene(BigDecimal higiene) {
        this.higiene = higiene;
    }

    public BigDecimal getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(BigDecimal comportamiento) {
        this.comportamiento = comportamiento;
    }

    public BigDecimal getAmabilidad() {
        return amabilidad;
    }

    public void setAmabilidad(BigDecimal amabilidad) {
        this.amabilidad = amabilidad;
    }

    public BigDecimal getGeneral() {
        return general;
    }

    public void setGeneral(BigDecimal general) {
        this.general = general;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.calificacionEncuentroPK);
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
        final CalificacionEncuentro other = (CalificacionEncuentro) obj;
        if (!Objects.equals(this.calificacionEncuentroPK, other.calificacionEncuentroPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Calificacion_Encuentro{" + "calificacionEncuentroPK=" + calificacionEncuentroPK + ", usuario=" + usuario + ", encuentro=" + encuentro + ", higiene=" + higiene + ", comportamiento=" + comportamiento + ", amabilidad=" + amabilidad + ", general=" + general + '}';
    }
    
       
    
}

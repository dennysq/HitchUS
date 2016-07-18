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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "UBICACION")
public class Ubicacion implements Serializable{
    
    @EmbeddedId
    UbicacionPK ubicacionPK;
    
    @Column(name = "FECHA")
    private Integer fecha;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false,insertable = false,updatable = false)
    private Usuario usuario;
    
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    
    @Column(name = "LONGITUD")
    private BigDecimal longitud;

    public Ubicacion() {
    }

    public UbicacionPK getUbicacionPK() {
        return ubicacionPK;
    }

    public void setUbicacionPK(UbicacionPK ubicacionPK) {
        this.ubicacionPK = ubicacionPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ubicacionPK);
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
        final Ubicacion other = (Ubicacion) obj;
        if (!Objects.equals(this.ubicacionPK, other.ubicacionPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "ubicacionPK=" + ubicacionPK + ", usuario=" + usuario + ", fecha=" + fecha + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }
    
}

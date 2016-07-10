/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Dennys
 */
@Entity
@Table(name = "ENCUENTRO")
public class Encuentro implements Serializable {

    @Id
    @Column(name = "ID_ENCUENTRO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ID_USUARIO1")
    private Integer idUsuario1;
            
    @Column(name = "ID_USUARIO2")
    private Integer idUsuario2;
    
    @Column(name = "FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Column(name = "ULTIMA_FECHA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ultimaFecha;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "NIVEL_COMPATIBILIDAD1")
    private BigDecimal nivelCompatibilidad1;
    
    @Column(name = "NIVEL_COMPATIBILIDAD2")
    private BigDecimal nivelCompatibilidad2;
    
    @Column(name = "CALIFICACION_PROMEDIO1")
    private BigDecimal calificacionPromedio1;

    @Column(name = "CALIFICACION_PROMEDIO2")
    private BigDecimal calificacionPromedio2;
    
    @Column(name = "ACEPTA_MATCH1")
    private String aceptaMatch1;
    
    @Column(name = "ACEPTA_MATCH2")
    private String aceptaMatch2;

    public Encuentro() {
    }

    public Encuentro(Integer idUsuario1, Integer idUsuario2, Date fechaCreacion, Date ultimaFecha, String estado, BigDecimal nivelCompatibilidad1, BigDecimal nivelCompatibilidad2, BigDecimal calificacionPromedio1, BigDecimal calificacionPromedio2, String aceptaMatch1, String aceptaMatch2) {
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
        this.fechaCreacion = fechaCreacion;
        this.ultimaFecha = ultimaFecha;
        this.estado = estado;
        this.nivelCompatibilidad1 = nivelCompatibilidad1;
        this.nivelCompatibilidad2 = nivelCompatibilidad2;
        this.calificacionPromedio1 = calificacionPromedio1;
        this.calificacionPromedio2 = calificacionPromedio2;
        this.aceptaMatch1 = aceptaMatch1;
        this.aceptaMatch2 = aceptaMatch2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Integer idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Integer getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Integer idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimaFecha() {
        return ultimaFecha;
    }

    public void setUltimaFecha(Date ultimaFecha) {
        this.ultimaFecha = ultimaFecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getNivelCompatibilidad1() {
        return nivelCompatibilidad1;
    }

    public void setNivelCompatibilidad1(BigDecimal nivelCompatibilidad1) {
        this.nivelCompatibilidad1 = nivelCompatibilidad1;
    }

    public BigDecimal getNivelCompatibilidad2() {
        return nivelCompatibilidad2;
    }

    public void setNivelCompatibilidad2(BigDecimal nivelCompatibilidad2) {
        this.nivelCompatibilidad2 = nivelCompatibilidad2;
    }

    public BigDecimal getCalificacionPromedio1() {
        return calificacionPromedio1;
    }

    public void setCalificacionPromedio1(BigDecimal calificacionPromedio1) {
        this.calificacionPromedio1 = calificacionPromedio1;
    }

    public BigDecimal getCalificacionPromedio2() {
        return calificacionPromedio2;
    }

    public void setCalificacionPromedio2(BigDecimal calificacionPromedio2) {
        this.calificacionPromedio2 = calificacionPromedio2;
    }

    public String getAceptaMatch1() {
        return aceptaMatch1;
    }

    public void setAceptaMatch1(String aceptaMatch1) {
        this.aceptaMatch1 = aceptaMatch1;
    }

    public String getAceptaMatch2() {
        return aceptaMatch2;
    }

    public void setAceptaMatch2(String aceptaMatch2) {
        this.aceptaMatch2 = aceptaMatch2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Encuentro other = (Encuentro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encuentro{" + "id=" + id + ", idUsuario1=" + idUsuario1 + ", idUsuario2=" + idUsuario2 + ", fechaCreacion=" + fechaCreacion + ", ultimaFecha=" + ultimaFecha + ", estado=" + estado + ", nivelCompatibilidad1=" + nivelCompatibilidad1 + ", nivelCompatibilidad2=" + nivelCompatibilidad2 + ", calificacionPromedio1=" + calificacionPromedio1 + ", calificacionPromedio2=" + calificacionPromedio2 + ", aceptaMatch1=" + aceptaMatch1 + ", aceptaMatch2=" + aceptaMatch2 + '}';
    }

}

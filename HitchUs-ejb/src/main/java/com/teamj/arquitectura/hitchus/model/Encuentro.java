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
import javax.persistence.SequenceGenerator;
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
    @SequenceGenerator(name = "ENCUENTRO_ID", sequenceName = "ENCUENTRO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ENCUENTRO_ID")
    @Column(name = "ID_ENCUENTRO")
    private Integer id;
    
    @Column(name = "ID_USUARIO1")
    private Usuario usuario1;
            
    @Column(name = "ID_USUARIO2")
    private Usuario usuario2;
    
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
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
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        return "Encuentro{" + "id=" + id + ", usuario1=" + usuario1 + ", usuario2=" + usuario2 + ", fechaCreacion=" + fechaCreacion + ", ultimaFecha=" + ultimaFecha + ", estado=" + estado + ", nivelCompatibilidad1=" + nivelCompatibilidad1 + ", nivelCompatibilidad2=" + nivelCompatibilidad2 + ", calificacionPromedio1=" + calificacionPromedio1 + ", calificacionPromedio2=" + calificacionPromedio2 + ", aceptaMatch1=" + aceptaMatch1 + ", aceptaMatch2=" + aceptaMatch2 + '}';
    }



}

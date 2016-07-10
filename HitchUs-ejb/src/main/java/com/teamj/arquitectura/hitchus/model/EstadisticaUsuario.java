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
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "ESTADISTICA_USUARIO")
public class EstadisticaUsuario implements Serializable{
    @Id
    @Column(name = "ID_USUARIO")
    private Usuario usuario;
    
    @Column(name = "HIGIENE")
    private BigDecimal higiene;
    
    @Column(name = "COMPORTAMIENTO")
    private BigDecimal comportamiento;
    
    @Column(name = "AMABILIDAD")
    private BigDecimal amabilidad;
    
    @Column(name = "GENERAL")
    private BigDecimal general;
    
    @Column(name = "BLOQUEOS")
    private Integer bloqueos;
    
    @Column(name = "PROMEDIO_ACTUAL")
    private BigDecimal promedioActual;
    
    @Column(name = "SOLICITUDES_ENVIADAS")
    private Integer solicitudesEnviadas;
    
    @Column(name = "SOLICITUDES_RECIBIDAS")
    private Integer solicitudesRecibidas;
    
    @Column(name = "MENSAJES_ENVIADOS")
    private Integer mensajesEnviados;
    
    @Column(name = "MENSAJES_RECIBIDOS")
    private Integer mensajesRecibidos;
    
    @Column(name = "ULTIMA_ACTUALIZACION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ultimaActualizacion;

    public EstadisticaUsuario() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Integer getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(Integer bloqueos) {
        this.bloqueos = bloqueos;
    }

    public BigDecimal getPromedioActual() {
        return promedioActual;
    }

    public void setPromedioActual(BigDecimal promedioActual) {
        this.promedioActual = promedioActual;
    }

    public Integer getSolicitudesEnviadas() {
        return solicitudesEnviadas;
    }

    public void setSolicitudesEnviadas(Integer solicitudesEnviadas) {
        this.solicitudesEnviadas = solicitudesEnviadas;
    }

    public Integer getSolicitudesRecibidas() {
        return solicitudesRecibidas;
    }

    public void setSolicitudesRecibidas(Integer solicitudesRecibidas) {
        this.solicitudesRecibidas = solicitudesRecibidas;
    }

    public Integer getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void setMensajesEnviados(Integer mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public Integer getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public void setMensajesRecibidos(Integer mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public Date getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(Date ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.usuario);
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
        final EstadisticaUsuario other = (EstadisticaUsuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EstadisticaUsuario{" + "usuario=" + usuario + ", higiene=" + higiene + ", comportamiento=" + comportamiento + ", amabilidad=" + amabilidad + ", general=" + general + ", bloqueos=" + bloqueos + ", promedioActual=" + promedioActual + ", solicitudesEnviadas=" + solicitudesEnviadas + ", solicitudesRecibidas=" + solicitudesRecibidas + ", mensajesEnviados=" + mensajesEnviados + ", mensajesRecibidos=" + mensajesRecibidos + ", ultimaActualizacion=" + ultimaActualizacion + '}';
    }

}

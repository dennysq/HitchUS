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
    private Integer id_usuario1;
            
    @Column(name = "ID_USUARIO2")
    private Integer id_usuario2;
    
    @Column(name = "FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_creacion;
    
    @Column(name = "ULTIMA_FECHA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ultima_fecha;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "NIVEL_COMPATIBILIDAD1")
    private BigDecimal nivel_compatibilidad1;
    
    @Column(name = "NIVEL_COMPATIBILIDAD2")
    private BigDecimal nivel_compatibilidad2;
    
    @Column(name = "CALIFICACION_PROMEDIO1")
    private BigDecimal calificacion_promedio1;

    @Column(name = "CALIFICACION_PROMEDIO2")
    private BigDecimal calificacion_promedio2;
    
    @Column(name = "ACEPTA_MATCH1")
    private String acepta_match1;
    
    @Column(name = "ACEPTA_MATCH2")
    private String acepta_match2;

    public Encuentro() {
    }

    public Encuentro(Integer id_usuario1, Integer id_usuario2, Date fecha_creacion, Date ultima_fecha, String estado, BigDecimal nivel_compatibilidad1, BigDecimal nivel_compatibilidad2, BigDecimal calificacion_promedio1, BigDecimal calificacion_promedio2, String acepta_match1, String acepta_match2) {
        this.id_usuario1 = id_usuario1;
        this.id_usuario2 = id_usuario2;
        this.fecha_creacion = fecha_creacion;
        this.ultima_fecha = ultima_fecha;
        this.estado = estado;
        this.nivel_compatibilidad1 = nivel_compatibilidad1;
        this.nivel_compatibilidad2 = nivel_compatibilidad2;
        this.calificacion_promedio1 = calificacion_promedio1;
        this.calificacion_promedio2 = calificacion_promedio2;
        this.acepta_match1 = acepta_match1;
        this.acepta_match2 = acepta_match2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_usuario1() {
        return id_usuario1;
    }

    public void setId_usuario1(Integer id_usuario1) {
        this.id_usuario1 = id_usuario1;
    }

    public Integer getId_usuario2() {
        return id_usuario2;
    }

    public void setId_usuario2(Integer id_usuario2) {
        this.id_usuario2 = id_usuario2;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getUltima_fecha() {
        return ultima_fecha;
    }

    public void setUltima_fecha(Date ultima_fecha) {
        this.ultima_fecha = ultima_fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getNivel_compatibilidad1() {
        return nivel_compatibilidad1;
    }

    public void setNivel_compatibilidad1(BigDecimal nivel_compatibilidad1) {
        this.nivel_compatibilidad1 = nivel_compatibilidad1;
    }

    public BigDecimal getNivel_compatibilidad2() {
        return nivel_compatibilidad2;
    }

    public void setNivel_compatibilidad2(BigDecimal nivel_compatibilidad2) {
        this.nivel_compatibilidad2 = nivel_compatibilidad2;
    }

    public BigDecimal getCalificacion_promedio1() {
        return calificacion_promedio1;
    }

    public void setCalificacion_promedio1(BigDecimal calificacion_promedio1) {
        this.calificacion_promedio1 = calificacion_promedio1;
    }

    public BigDecimal getCalificacion_promedio2() {
        return calificacion_promedio2;
    }

    public void setCalificacion_promedio2(BigDecimal calificacion_promedio2) {
        this.calificacion_promedio2 = calificacion_promedio2;
    }

    public String getAcepta_match1() {
        return acepta_match1;
    }

    public void setAcepta_match1(String acepta_match1) {
        this.acepta_match1 = acepta_match1;
    }

    public String getAcepta_match2() {
        return acepta_match2;
    }

    public void setAcepta_match2(String acepta_match2) {
        this.acepta_match2 = acepta_match2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        return "Encuentro{" + "id=" + id + ", id_usuario1=" + id_usuario1 + ", id_usuario2=" + id_usuario2 + ", fecha_creacion=" + fecha_creacion + ", ultima_fecha=" + ultima_fecha + ", estado=" + estado + ", nivel_compatibilidad1=" + nivel_compatibilidad1 + ", nivel_compatibilidad2=" + nivel_compatibilidad2 + ", calificacion_promedio1=" + calificacion_promedio1 + ", calificacion_promedio2=" + calificacion_promedio2 + ", acepta_match1=" + acepta_match1 + ", acepta_match2=" + acepta_match2 + '}';
    }

}

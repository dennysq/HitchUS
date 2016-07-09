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
    
//    @JoinColumn(name = "ID_USUARIO" , referencedColumnName = "ID_USUARIO")
//    @ManyToOne
//    Usuario usuario;

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//    
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getResumen() {
//        return resumen;
//    }
//
//    public void setResumen(String resumen) {
//        this.resumen = resumen;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 41 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Encuentro other = (Encuentro) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }
    
    
}

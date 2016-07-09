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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CERTIFICADO")
public class Certificado implements Serializable{
    
    @EmbeddedId
    CertificadoPK certificadoPK;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false,insertable = false,updatable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_CERTIFICADO", nullable = false,insertable = false,updatable = false)
    private  Tipo_Certificado tipoCertificado;
    
    @Column(name = "ID_ENTIDAD_CERTIFICADORA")
    private Integer id;
    
    @Column(name = "PATH")
    private String path;
    
    @Column(name = "FECHA_RECEPCION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_recepcion;
    
    @Column(name = "FECHA_VALIDACION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_validacion;
    
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_caducidad;
    
    @Column(name = "RESULTADO")
    private String resultado;
    
    @Column(name = "VERIFICADO")
    private String verificado;

    public Certificado() {
    }

    public CertificadoPK getCertificadoPK() {
        return certificadoPK;
    }

    public void setCertificadoPK(CertificadoPK certificadoPK) {
        this.certificadoPK = certificadoPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipo_Certificado getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(Tipo_Certificado tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Date getFecha_validacion() {
        return fecha_validacion;
    }

    public void setFecha_validacion(Date fecha_validacion) {
        this.fecha_validacion = fecha_validacion;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getVerificado() {
        return verificado;
    }

    public void setVerificado(String verificado) {
        this.verificado = verificado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.certificadoPK);
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
        final Certificado other = (Certificado) obj;
        if (!Objects.equals(this.certificadoPK, other.certificadoPK)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Certificado{" + "certificadoPK=" + certificadoPK + ", usuario=" + usuario + ", tipoCertificado=" + tipoCertificado + ", id=" + id + ", path=" + path + ", fecha_recepcion=" + fecha_recepcion + ", fecha_validacion=" + fecha_validacion + ", fecha_caducidad=" + fecha_caducidad + ", resultado=" + resultado + ", verificado=" + verificado + '}';
    }
    
    
}

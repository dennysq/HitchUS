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
    private  TipoCertificado tipoCertificado;
    @ManyToOne
    @JoinColumn(name = "ID_ENTIDAD_CERTIFICADORA")
    private EntidadCertificadora entidadCertificadora;
    
    @Column(name = "PATH")
    private String path;
    
    @Column(name = "FECHA_RECEPCION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    
    @Column(name = "FECHA_VALIDACION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValidacion;
    
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    
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

    public TipoCertificado getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(TipoCertificado tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public EntidadCertificadora getEntidadCertificadora() {
        return entidadCertificadora;
    }

    public void setEntidadCertificadora(EntidadCertificadora entidadCertificadora) {
        this.entidadCertificadora = entidadCertificadora;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Date getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(Date fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
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
        hash = 71 * hash + Objects.hashCode(this.certificadoPK);
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
        return "Certificado{" + "certificadoPK=" + certificadoPK + ", usuario=" + usuario + ", tipoCertificado=" + tipoCertificado + ", entidadCertificadora=" + entidadCertificadora + ", path=" + path + ", fechaRecepcion=" + fechaRecepcion + ", fechaValidacion=" + fechaValidacion + ", fechaCaducidad=" + fechaCaducidad + ", resultado=" + resultado + ", verificado=" + verificado + '}';
    }

}

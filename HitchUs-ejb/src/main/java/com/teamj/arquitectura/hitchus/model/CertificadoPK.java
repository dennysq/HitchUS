/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Klever
 */
@Embeddable
public class CertificadoPK implements Serializable{
    
    @Column(name = "ID_USUARIO")
    private Integer usuario;
     
    @Column(name = "ID_TIPO_CERTIFICADO")
    private Integer tipoCertificado;

    public CertificadoPK() {
    }

    public CertificadoPK(Integer usuario, Integer tipoCertificado) {
        this.usuario = usuario;
        this.tipoCertificado = tipoCertificado;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(Integer tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + Objects.hashCode(this.tipoCertificado);
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
        final CertificadoPK other = (CertificadoPK) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.tipoCertificado, other.tipoCertificado)) {
            return false;
        }
        return true;
    }

    
}

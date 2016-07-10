/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Klever
 */
@Embeddable
public class CertificadoPK implements Serializable{
    
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
     
    @Column(name = "ID_TIPO_CERTIFICADO")
    private Integer idTipoCertificado;

    public CertificadoPK() {
    }

    public CertificadoPK(Integer idUsuario, Integer idTipoCertificado) {
        this.idUsuario = idUsuario;
        this.idTipoCertificado = idTipoCertificado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoCertificado() {
        return idTipoCertificado;
    }

    public void setIdTipoCertificado(Integer idTipoCertificado) {
        this.idTipoCertificado = idTipoCertificado;
    }
    
    
    
    
}

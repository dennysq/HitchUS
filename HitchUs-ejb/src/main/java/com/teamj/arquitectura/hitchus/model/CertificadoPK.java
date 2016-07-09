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
    private Integer id_usuario;
     
    @Column(name = "ID_TIPO_CERTIFICADO")
    private Integer id_tipo_certificado;

    public CertificadoPK() {
    }

    public CertificadoPK(Integer id_usuario, Integer id_tipo_certificado) {
        this.id_usuario = id_usuario;
        this.id_tipo_certificado = id_tipo_certificado;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_tipo_certificado() {
        return id_tipo_certificado;
    }

    public void setId_tipo_certificado(Integer id_tipo_certificado) {
        this.id_tipo_certificado = id_tipo_certificado;
    }
    
    
}

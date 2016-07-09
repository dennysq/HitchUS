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
public class MensajePK implements Serializable{
    @Column(name = "ID_ENC")
    private Integer id_enc;
     
    @Column(name = "SEC_MENSAJE")
    private Integer sec_mensaje;

    public MensajePK() {
    }

    public MensajePK(Integer id_enc, Integer sec_mensaje) {
        this.id_enc = id_enc;
        this.sec_mensaje = sec_mensaje;
    }

    public Integer getId_enc() {
        return id_enc;
    }

    public void setId_enc(Integer id_enc) {
        this.id_enc = id_enc;
    }

    public Integer getSec_mensaje() {
        return sec_mensaje;
    }

    public void setSec_mensaje(Integer sec_mensaje) {
        this.sec_mensaje = sec_mensaje;
    }
    
    
}

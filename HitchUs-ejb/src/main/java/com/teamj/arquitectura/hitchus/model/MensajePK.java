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
    private Encuentro encuentro;
     
    @Column(name = "SEC_MENSAJE")
    private Integer secMensaje;

    public MensajePK() {
    }

    public MensajePK(Encuentro encuentro, Integer secMensaje) {
        this.encuentro = encuentro;
        this.secMensaje = secMensaje;
    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public Integer getSecMensaje() {
        return secMensaje;
    }

    public void setSecMensaje(Integer secMensaje) {
        this.secMensaje = secMensaje;
    }

}

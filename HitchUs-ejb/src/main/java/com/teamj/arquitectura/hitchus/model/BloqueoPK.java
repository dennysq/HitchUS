/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

/**
 *
 * @author Klever
 */
@Embeddable
public class BloqueoPK implements Serializable{

    @Column(name = "ID_USUARIO1")
    private Integer idUsuario1;
     
    @Column(name = "ID_USUARIO2")
    private Integer idUsuario2;

    public BloqueoPK() {
    }
    
    public BloqueoPK(Integer idUsuario1, Integer idUsuario2) {
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
    }

    public Integer getId_usuario1() {
        return idUsuario1;
    }

    public void setId_usuario1(Integer idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Integer getId_usuario2() {
        return idUsuario2;
    }

    public void setId_usuario2(Integer idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

}

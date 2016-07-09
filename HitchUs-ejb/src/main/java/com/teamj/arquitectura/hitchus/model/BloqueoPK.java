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
    private Integer id_usuario1;
     
    @Column(name = "ID_USUARIO2")
    private Integer id_usuario2;

    public BloqueoPK() {
    }
    
    public BloqueoPK(Integer id_usuario1, Integer id_usuario2) {
        this.id_usuario1 = id_usuario1;
        this.id_usuario2 = id_usuario2;
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
    
    
}

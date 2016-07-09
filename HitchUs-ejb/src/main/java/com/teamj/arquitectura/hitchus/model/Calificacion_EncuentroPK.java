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
public class Calificacion_EncuentroPK implements Serializable{
    
    @Column(name = "ID_ENCUENTRO")
    private Integer id_encuentro;
     
    @Column(name = "ID_USUARIO")
    private Integer id_usuario;

    public Calificacion_EncuentroPK() {
    }

    public Calificacion_EncuentroPK(Integer id_encuentro, Integer id_usuario) {
        this.id_encuentro = id_encuentro;
        this.id_usuario = id_usuario;
    }

    public Integer getId_encuentro() {
        return id_encuentro;
    }

    public void setId_encuentro(Integer id_encuentro) {
        this.id_encuentro = id_encuentro;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

}

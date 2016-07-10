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
public class CalificacionEncuentroPK implements Serializable{
    
    @Column(name = "ID_ENCUENTRO")
    private Integer idEncuentro;
     
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    public CalificacionEncuentroPK() {
    }

    public CalificacionEncuentroPK(Integer idEncuentro, Integer idUsuario) {
        this.idEncuentro = idEncuentro;
        this.idUsuario = idUsuario;
    }

    public Integer getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(Integer idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}

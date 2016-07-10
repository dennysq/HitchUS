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
public class UbicacionPK implements Serializable{
    
    @Column(name = "FECHA")
    private Integer fecha;
     
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    public UbicacionPK() {
    }

    public UbicacionPK(Integer fecha, Integer idUsuario) {
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}

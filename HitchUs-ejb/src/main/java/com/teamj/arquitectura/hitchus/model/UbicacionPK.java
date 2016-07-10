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
    private Usuario usuario;

    public UbicacionPK() {
    }

    public UbicacionPK(Integer fecha, Usuario usuario) {
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
}

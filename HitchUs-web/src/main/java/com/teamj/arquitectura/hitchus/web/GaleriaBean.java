/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Dennys
 */
@ViewScoped
@ManagedBean
public class GaleriaBean implements Serializable {

    @EJB
    UsuarioServicio usuarioServicio;
    private List<Imagen> imagenes;
    private Imagen imagenSeleccionada;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    @PostConstruct
    public void init() {
        imagenes = usuarioServicio.obtenerImagenesPorUsuario(sessionBean.getUser());
    }

    public Imagen getImagenSeleccionada() {
        return imagenSeleccionada;
    }

    public void setImagenSeleccionada(Imagen imagenSeleccionada) {
        this.imagenSeleccionada = imagenSeleccionada;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
    
    public String todayDate() {
      
        return new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    }

}

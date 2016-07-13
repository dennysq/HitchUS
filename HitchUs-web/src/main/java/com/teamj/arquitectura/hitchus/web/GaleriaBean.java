/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.services.ImagenServicio;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Dennys
 */
@ViewScoped
@ManagedBean
public class GaleriaBean implements Serializable {

    @EJB
    UsuarioServicio usuarioServicio;
    @EJB
    ImagenServicio imagenServicio;
    private List<Imagen> imagenes;
    private Imagen imagenSeleccionada;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    private boolean cargarNuevaImagen;

    @PostConstruct
    public void init() {
        imagenes = usuarioServicio.obtenerImagenesPorUsuario(sessionBean.getUser());
    }

    public void setCargarNuevaImagen(boolean cargarNuevaImagen) {
        this.cargarNuevaImagen = cargarNuevaImagen;
    }

    public boolean isCargarNuevaImagen() {
        return cargarNuevaImagen;
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

   

    public void setProfilePicture(Imagen image) {
        int indice = this.imagenes.indexOf(image);
        for (int i = 0; i < imagenes.size(); i++) {
            if (indice == i) {
                imagenes.get(i).setPerfil(true);
            } else {
                imagenes.get(i).setPerfil(false);
            }
            imagenServicio.actualizar(imagenes.get(i));
        }
    }

    public void handleFileUpload(FileUploadEvent event) {

        try {
            usuarioServicio.guardarImagen(event.getFile().getInputstream(), "C:\\hitchus", "nombre", sessionBean.getUser(), "prueba", true, false);
            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            imagenes=imagenServicio.obtenerImagenesPorUsuario(sessionBean.getUser());
        } catch (IOException ex) {
            
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showFileUploadDialog(){
        cargarNuevaImagen=true;
    }
    public void hideFileUploadDialog(){
    cargarNuevaImagen=false;
    }
}

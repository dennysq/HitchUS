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
import org.primefaces.model.UploadedFile;

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
    @ManagedProperty(value = "#{constant}")
    private Constant constant;
    private boolean cargarNuevaImagen;
    private String nombre;
    private String descripcion;
    private String fileName;

    private UploadedFile file;

    @PostConstruct
    public void init() {
        imagenes = usuarioServicio.obtenerImagenesPorUsuario(sessionBean.getUser());
        fileName = "No se ha elegido un archivo";

    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public Constant getConstant() {
        return constant;
    }

    public void setConstant(Constant constant) {
        this.constant = constant;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public void updateState(Imagen image) {

        if (imagenServicio.actualizar(this.imagenes.get(this.imagenes.indexOf(image)))) {

        }
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

    public void eliminarFotografia(Imagen imagen) {
        imagenes.remove(imagen);
        imagenServicio.eliminar(imagen.getId());
    }

    public void handleFileUpload(FileUploadEvent event) {
//        try {
        //usuarioServicio.guardarImagen(file.getInputstream(), nombre, sessionBean.getUser(), descripcion, true, false);
        file = event.getFile();
        FacesMessage message = new FacesMessage("Imagen ", file.getFileName() + " cargada correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        fileName = file.getFileName();
        //imagenes = imagenServicio.obtenerImagenesPorUsuario(sessionBean.getUser());
//        } catch (IOException ex) {
//
//            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void showFileUploadDialog() {
        cargarNuevaImagen = true;
        file = null;
        fileName = "No se ha elegido un archivo";
    }

    public void hideFileUploadDialog() {
        cargarNuevaImagen = false;
        file = null;
        fileName = "No se ha elegido un archivo";
    }

    public void upload() {
        if (file != null) {
            try {
                usuarioServicio.guardarImagen(file.getInputstream(), constant.getImagesPath(), nombre, sessionBean.getUser(), descripcion, true, false);
                FacesMessage message = new FacesMessage("Imagen ", file.getFileName() + " cargada correctamente.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                imagenes = imagenServicio.obtenerImagenesPorUsuario(sessionBean.getUser());
                hideFileUploadDialog();
            } catch (IOException ex) {

                Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ", "El archivo no ha sido cargado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}

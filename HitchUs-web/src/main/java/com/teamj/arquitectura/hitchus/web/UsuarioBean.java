/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.exception.ValidationException;
import com.teamj.arquitectura.hitchus.model.PaisOrigen;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Dennys
 */
@ViewScoped
@ManagedBean
public class UsuarioBean extends CrudBean implements Serializable {

    @EJB
    private UsuarioServicio usuarioServicio;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private Usuario usuario;
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;
    private List<PaisOrigen> paisOrigenLista;
    private Integer idPaisOrigenSeleccionado;
    private PaisOrigen pais;

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public Integer getIdPaisOrigenSeleccionado() {
        return idPaisOrigenSeleccionado;
    }

    public void setIdPaisOrigenSeleccionado(Integer idPaisOrigenSeleccionado) {
        this.idPaisOrigenSeleccionado = idPaisOrigenSeleccionado;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<PaisOrigen> getPaisOrigenLista() {
        return paisOrigenLista;
    }

    public void setPaisOrigenLista(List<PaisOrigen> paisOrigenLista) {
        this.paisOrigenLista = paisOrigenLista;
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.paisOrigenLista= this.usuarioServicio.obtenerPaises();
        try {
            BeanUtils.copyProperties(this.usuario, sessionBean.getUser());
            
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
    }

    public void beginModification() {
        this.beginModify();
    }

//    public void becomeAProvider() {
//        this.beginModify();
//        this.usuario = new Usuario();
//        try {
//            BeanUtils.copyProperties(this.usuario, sessionBean.getUser());
//            this.usuario.setActivo("P");
//            usuarioServicio.actualizar(this.usuario);
//            sessionBean.getUser().setActivo("P");
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nuevo Proveedor", " Debes cerrar sesión para que los cambios tengan efecto "));
//        } catch (IllegalAccessException | InvocationTargetException | ValidationException e) {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
//        }
//    }
    public void update() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuarioServicio.editarPerfil(this.usuario);
            BeanUtils.copyProperties(sessionBean.getUser(), this.usuario);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La información del usuario se ha actualizado correctamente"));

        } catch (ValidationException | IllegalAccessException | InvocationTargetException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
        RequestContext.getCurrentInstance().execute("PF('agregar_dialog_var').hide()");
        this.reset();
        // this.usuarioSelected=null;
    }

    public void cancel() {
        this.usuario = new Usuario();
        try {
            BeanUtils.copyProperties(this.usuario, sessionBean.getUser());
        } catch (IllegalAccessException | InvocationTargetException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
        this.reset();

    }

    public void changePassword() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.usuarioServicio.cambiarContraseña(sessionBean.getUser(), oldPassword, newPassword, reNewPassword)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La contraseña ha sido actualizada"));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La contraseña no pudo ser actualizada"));
        }
        this.reset();
    }
}

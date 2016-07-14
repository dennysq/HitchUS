/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.ApplicationContext;
import com.teamj.arquitectura.hitchus.exception.ValidationException;
import com.teamj.arquitectura.hitchus.model.CiudadResidencia;
import com.teamj.arquitectura.hitchus.model.PaisOrigen;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author RICARDO
 */
@ViewScoped
@ManagedBean
public class ConfiguracionBean extends CrudBean implements Serializable {

    @EJB
    private UsuarioServicio usuarioServicio;

    @EJB
    private ApplicationContext applicationContext;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private Usuario usuario;
    private Map<String, String> estado;
    private Map<String, String> premium;

    public ConfiguracionBean() {
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Map<String, String> getEstado() {
        return estado;
    }

    public void setEstado(Map<String, String> estado) {
        this.estado = estado;
    }

    public Map<String, String> getPremium() {
        return premium;
    }

    public void setPremium(Map<String, String> premium) {
        this.premium = premium;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {
        try {
            BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
            beanUtilsBean.getConvertUtils().register(
                    new org.apache.commons.beanutils.converters.BigDecimalConverter(null), BigDecimal.class);

            this.usuario = new Usuario();
            this.estado = applicationContext.getEstado();

            BeanUtils.copyProperties(this.usuario, sessionBean.getUser());
            System.out.println(""+usuario);
            System.out.println(""+sessionBean.getUser());
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado"+e, e.getMessage()));
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
            System.out.println(""+usuario);
            usuarioServicio.editarPerfil(this.usuario);
            System.out.println("llego al editar");
            BeanUtils.copyProperties(sessionBean.getUser(), this.usuario);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La información del usuario se ha actualizado correctamente"));
            System.out.println(""+sessionBean.getUser());
        } catch (ValidationException | IllegalAccessException | InvocationTargetException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
//        RequestContext.getCurrentInstance().execute("PF('agregar_dialog_var').hide()");
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

    public void cambiarEstado() {
        this.usuario.setPremium("P");
        usuarioServicio.editarPerfil(usuario);

        try {
            BeanUtils.copyProperties(sessionBean.getUser(),this.usuario);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud Enviada con Éxito", null));
        } catch (IllegalAccessException | InvocationTargetException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));

        }
    }

}

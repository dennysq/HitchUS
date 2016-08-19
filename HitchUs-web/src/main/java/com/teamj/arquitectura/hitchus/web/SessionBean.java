/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.client.SuscripcionCliente;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dennys
 */
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

    public static final String HOME_PAGE_REDIRECT = "/user/home.xhtml?faces-redirect=true";
    public static final String LOGOUT_PAGE_REDIRECT = "/login.xhtml?faces-redirect=true";
    public static final Integer MAX_LOGIN_ATTEMPS = 3;
    private Integer loginAttemps;
    private SuscripcionCliente suscripcionCliente;
    @EJB
    UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {
        loginAttemps = 0;
    }

    public void addAttemp() {
        loginAttemps++;
    }

    public void setLoginAttemps(Integer loginAttemps) {
        this.loginAttemps = loginAttemps;
    }

    public Integer getLoginAttemps() {
        return loginAttemps;
    }

    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public String login(Usuario u) {

        this.user = u;
        try {
            suscripcionCliente = new SuscripcionCliente();

            String estadoPremium = suscripcionCliente.consultarEstadoSolicitud(String.valueOf(u.getId()));
            if (estadoPremium != null && estadoPremium.equals("V") && u.getPremium() != null && !u.getPremium().equals("V")) {
                user.setPremium(estadoPremium);
                usuarioServicio.editarPerfil(u);
            }
        } catch (Exception e) {
            System.out.println("tranqui");

        }

        return HOME_PAGE_REDIRECT;

    }

    public String logout() {
        // invalidate the session
        this.user = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        loginAttemps = 0;
        return LOGOUT_PAGE_REDIRECT;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public String isLoggedInForwardHome() {
        if (isLoggedIn()) {
            return HOME_PAGE_REDIRECT;
        }
        return null;
    }
    /**
     *
     * @return si es el usuario administrador del sistema
     */
//    public boolean isAdmin() {
//        if (user != null) {
//            return user.getNombre().equals("admin");
//        }
//        return false;
//    }

}

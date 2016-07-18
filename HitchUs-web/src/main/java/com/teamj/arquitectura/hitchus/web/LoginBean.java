/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.exception.ValidationException;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@ViewScoped
@ManagedBean
public class LoginBean implements Serializable {

    private String correoUsuario;
    private String claveUsuario;
    private String codigoTelefonicoSeleccionado;
    private String codigoTelefonico;

    private String correoUsuarioL;
    private String claveUsuarioL;
    private String nicknameUsuario;
    private String telefonoUsuario;
    private Date fechaNacimiento;

    @EJB
    private UsuarioServicio usuarioServicio;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    public String getCodigoTelefonico() {
        return codigoTelefonico;
    }

    public void setCodigoTelefonico(String codigoTelefonico) {
        this.codigoTelefonico = codigoTelefonico;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setCodigoTelefonicoSeleccionado(String codigoTelefonicoSeleccionado) {
        this.codigoTelefonicoSeleccionado = codigoTelefonicoSeleccionado;
    }

    public String getCodigoTelefonicoSeleccionado() {
        return codigoTelefonicoSeleccionado;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getCorreoUsuarioL() {
        return correoUsuarioL;
    }

    public void setCorreoUsuarioL(String correoUsuarioL) {
        this.correoUsuarioL = correoUsuarioL;
    }

    public String getClaveUsuarioL() {
        return claveUsuarioL;
    }

    public void setClaveUsuarioL(String claveUsuarioL) {
        this.claveUsuarioL = claveUsuarioL;
    }

    public String getNicknameUsuario() {
        return nicknameUsuario;
    }

    public void setNicknameUsuario(String nicknameUsuario) {
        this.nicknameUsuario = nicknameUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    @PostConstruct
    public void init() {
        // this.usuario = new Usuario();
        this.codigoTelefonicoSeleccionado="+593";
    }

    public String maxDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -18);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(c.getTime());
    }

    public void submitCaptcha() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String login() {

        FacesMessage msg = null;
        if (correoUsuario != null && !correoUsuario.isEmpty() && claveUsuario != null && !claveUsuario.isEmpty()) {

//            Usuario u = new Usuario();
//            u.setEmail(correoUsuario);
            Usuario loggedUser = usuarioServicio.ingresar(correoUsuario, claveUsuario);
            try {
                if (loggedUser != null) {

                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", loggedUser);
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    return this.sessionBean.login(loggedUser);

                } else {

                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error",
                            "Credenciales no válidas");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    sessionBean.addAttemp();
                }
            } catch (Exception e) {
            }
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Llene todos los campos para continuar");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
        return null;
    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();

    }

    public void beginSignUp() {
        nicknameUsuario = "";
        claveUsuarioL = "";
        correoUsuarioL = "";
        claveUsuario = "";
        correoUsuario = "";
        telefonoUsuario = "";
        fechaNacimiento = null;
    }

    public void signUp() {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (claveUsuarioL != null && !claveUsuarioL.isEmpty()
                    && correoUsuarioL != null && !correoUsuarioL.isEmpty()
                    && telefonoUsuario != null && !telefonoUsuario.isEmpty()
                    && fechaNacimiento != null
                    && nicknameUsuario != null && !nicknameUsuario.isEmpty()) {

                Usuario u = new Usuario();

                u.setEmail(correoUsuarioL);
                u.setPassword(claveUsuarioL);
                u.setNickname(nicknameUsuario);
                u.setNumeroTelefonico(codigoTelefonicoSeleccionado+telefonoUsuario);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaNacimiento);
                int mes = calendar.get(Calendar.MONTH);
                int anio = calendar.get(Calendar.YEAR);
                u.setMesNacimiento(mes);
                u.setAnioNacimiento(anio);
                if (usuarioServicio.registrar(u)) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "El registro se completó correctamente"));
                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro", "El correo de usuario ya existe"));
                }
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro", "Complete todos los campos para continuar"));
            }
        } catch (ValidationException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
        this.correoUsuario = this.correoUsuarioL;
        RequestContext.getCurrentInstance().execute("PF('signup_dialog_var').hide()");

    }
}

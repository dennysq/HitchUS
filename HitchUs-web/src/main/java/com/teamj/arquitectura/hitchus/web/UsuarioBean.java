/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.client.SuscripcionCliente;
import com.teamj.arquitectura.hitchus.exception.ValidationException;
import com.teamj.arquitectura.hitchus.model.CiudadResidencia;
import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.model.PaisOrigen;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
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

    @ManagedProperty(value = "#{constant}")
    private Constant constant;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    SuscripcionCliente suscripcionCliente;
    private Usuario usuario;
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;
    private String rutaFotoDePerfil;
    private Date fechaNacimiento;
    private List<PaisOrigen> paisOrigenLista;
    private List<CiudadResidencia> ciudadResidenciaLista;
    private Map<String, String> genero;
    private Map<String, String> nivelDeEducacion;
    private Map<String, String> siNo;

    private Integer idPaisOrigenSeleccionado;
    private Integer idCiudadResidenciaSeleccionada;

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public String getRutaFotoDePerfil() {
        return rutaFotoDePerfil;
    }

    public void setRutaFotoDePerfil(String rutaFotoDePerfil) {
        this.rutaFotoDePerfil = rutaFotoDePerfil;
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

    public void setConstant(Constant constant) {
        this.constant = constant;
    }

    public Constant getConstant() {
        return constant;
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

    public Map<String, String> getGenero() {
        return genero;
    }

    public void setGenero(Map<String, String> genero) {
        this.genero = genero;
    }

    public Map<String, String> getNivelDeEducacion() {
        return nivelDeEducacion;
    }

    public void setNivelDeEducacion(Map<String, String> nivelDeEducacion) {
        this.nivelDeEducacion = nivelDeEducacion;
    }

    public Map<String, String> getSiNo() {
        return siNo;
    }

    public void setSiNo(Map<String, String> siNo) {
        this.siNo = siNo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<CiudadResidencia> getCiudadResidenciaLista() {
        return ciudadResidenciaLista;
    }

    public void setCiudadResidenciaLista(List<CiudadResidencia> ciudadResidenciaLista) {
        this.ciudadResidenciaLista = ciudadResidenciaLista;
    }

    public Integer getIdCiudadResidenciaSeleccionada() {
        return idCiudadResidenciaSeleccionada;
    }

    public void setIdCiudadResidenciaSeleccionada(Integer idCiudadResidenciaSeleccionada) {
        this.idCiudadResidenciaSeleccionada = idCiudadResidenciaSeleccionada;
    }

    @PostConstruct
    public void init() {
        BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
        beanUtilsBean.getConvertUtils().register(
                new org.apache.commons.beanutils.converters.BigDecimalConverter(null), BigDecimal.class);
        this.usuario = new Usuario();
        this.paisOrigenLista = this.usuarioServicio.obtenerPaises();
        this.ciudadResidenciaLista = this.usuarioServicio.obtenerCiudades();
        this.genero = constant.getGenero();
        this.nivelDeEducacion = constant.getNivelDeEducacion();
        this.siNo = constant.getSiNo();
        try {
            BeanUtils.copyProperties(this.usuario, sessionBean.getUser());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-yyyy");
            this.fechaNacimiento = simpleDateFormat.parse(usuario.getMesNacimiento() + "-" + usuario.getAnioNacimiento());

            for (PaisOrigen p : this.paisOrigenLista) {
                if (this.usuario.getPaisOrigen() != null && this.usuario.getPaisOrigen().equals(p)) {
                    this.idPaisOrigenSeleccionado = p.getId();
                    break;
                }
            }
            for (CiudadResidencia c : this.ciudadResidenciaLista) {
                if (this.usuario.getCiudadResidencia() != null && this.usuario.getCiudadResidencia().equals(c)) {
                    this.idCiudadResidenciaSeleccionada = c.getId();
                    break;
                } else {
                }

            }

            System.out.println("" + usuario);
            obtenerFotoDePerfil();
        } catch (IllegalAccessException | InvocationTargetException | ParseException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
        
    }

    public void beginModification() {
        this.beginModify();
    }

    public void update() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            for (PaisOrigen p : this.paisOrigenLista) {
                if (this.idPaisOrigenSeleccionado.equals(p.getId())) {
                    this.usuario.setPaisOrigen(p);
                    break;
                }
            }
            for (CiudadResidencia c : this.ciudadResidenciaLista) {
                if (this.idCiudadResidenciaSeleccionada.equals(c.getId())) {
                    this.usuario.setCiudadResidencia(c);
                    break;
                }
            }
            usuarioServicio.editarPerfil(this.usuario);
            BeanUtils.copyProperties(sessionBean.getUser(), this.usuario);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La información del usuario se ha actualizado correctamente"));
            this.reset();
        } catch (ValidationException | IllegalAccessException | InvocationTargetException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
        //RequestContext.getCurrentInstance().execute("PF('agregar_dialog_var').hide()");

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

    private void obtenerFotoDePerfil() {

        Imagen i = usuarioServicio.obtenerImagenPerfil(sessionBean.getUser());
        if (i != null) {
            rutaFotoDePerfil = "../imageshitchus/" + i.getId() + ".jpg";
        } else if (sessionBean.getUser().getGenero().equals("FEM")) {
            rutaFotoDePerfil = "../images/fb-woman-profile.jpg";
        } else {
            rutaFotoDePerfil = "../images/fb-man-profile.jpg";
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.client.SuscripcionCliente;
import com.teamj.arquitectura.hitchus.exception.ValidationException;
import com.teamj.arquitectura.hitchus.model.Certificado;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.services.CertificadoServicio;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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
    private CertificadoServicio certificadoServicio;
    @ManagedProperty(value = "#{constant}")
    private Constant constant;
    private List<Certificado> certificadosUsuario;
    private Certificado certificadoSeleccionado;
    private UploadedFile file;
    private String fileName;
    private String enfermedadSeleccionada;
    private SuscripcionCliente suscripcionCliente;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private Usuario usuario;
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;
    private Map<String, String> estado;
    private Map<String, String> premium;

    public String getOldPassword() {
        return oldPassword;
    }

    public Certificado getCertificadoSeleccionado() {
        return certificadoSeleccionado;
    }

    public void setCertificadoSeleccionado(Certificado certificadoSeleccionado) {
        this.certificadoSeleccionado = certificadoSeleccionado;
    }

    public void setCertificadosUsuario(List<Certificado> certificadosUsuario) {
        this.certificadosUsuario = certificadosUsuario;
    }

    public List<Certificado> getCertificadosUsuario() {
        return certificadosUsuario;
    }

    public void setEnfermedadSeleccionada(String enfermedadSeleccionada) {
        this.enfermedadSeleccionada = enfermedadSeleccionada;
    }

    public String getEnfermedadSeleccionada() {
        return enfermedadSeleccionada;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public ConfiguracionBean() {
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setConstant(Constant constant) {
        this.constant = constant;
    }

    public Constant getConstant() {
        return constant;
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
            this.estado = constant.getEstado();
            certificadosUsuario = certificadoServicio.obtenerCertificadosPorUsuario(sessionBean.getUser());
            BeanUtils.copyProperties(this.usuario, sessionBean.getUser());
            System.out.println("" + usuario);
            System.out.println("" + sessionBean.getUser());
            enfermedadSeleccionada = "VIH SIDA";
            actualizarEnfermedadSeleccionada();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado" + e, e.getMessage()));
        }
    }

    public void beginModification() {
        this.beginModify();
    }

    public void update() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            System.out.println("" + usuario);
            usuarioServicio.editarPerfil(this.usuario);
            System.out.println("llego al editar");
            BeanUtils.copyProperties(sessionBean.getUser(), this.usuario);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La información del usuario se ha actualizado correctamente"));
            System.out.println("" + sessionBean.getUser());
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

//    public void dummy() {
//        if (file != null) {
//            System.out.println("archivo subido");
//            FacesMessage message = new FacesMessage("Succesful", fileSida.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
//    }
    public void cancelFileUpload() {

        file = null;
        fileName = "No se ha elegido un archivo";
    }

    public void upload() {
        if (file != null) {
            try {
                String name = "";
                if (enfermedadSeleccionada != null) {
                    name = enfermedadSeleccionada;
                } else {
                    name = fileName;
                }

                certificadoServicio.guardarArchivo(file.getInputstream(), constant.getImagesPath(), name, certificadoSeleccionado);
                FacesMessage message = new FacesMessage("Archivo ", file.getFileName() + " enviado correctamente.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                cancelFileUpload();
            } catch (IOException ex) {
                System.out.println("" + ex);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", ex.toString());
                FacesContext.getCurrentInstance().addMessage(null, message);
                Logger.getLogger(ConfiguracionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ", "El archivo no ha sido cargado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void cambiarEstado() {
        suscripcionCliente = new SuscripcionCliente();
        try {
            List<Certificado> cer = certificadoServicio.obtenerCertificadosPorUsuario(usuario);
            String her = "";
            String sida = "";
            String cla = "";
            String tri = "";
            String sif = "";
            String gon = "";

            for (Certificado c : cer) {
                if (c.getTipoCertificado().getNombreEnfermedad().equals("Herpes")) {
                    her = c.getNombreArchivo();
                }
                if (c.getTipoCertificado().getNombreEnfermedad().equals("Tricomoniasis")) {
                    tri = c.getNombreArchivo();
                }
                if (c.getTipoCertificado().getNombreEnfermedad().equals("Clamidia")) {
                    cla = c.getNombreArchivo();
                }
                if (c.getTipoCertificado().getNombreEnfermedad().equals("Sífilis")) {
                    sif = c.getNombreArchivo();
                }
                if (c.getTipoCertificado().getNombreEnfermedad().equals("Gonorrea")) {
                    gon = c.getNombreArchivo();
                }
                if (c.getTipoCertificado().getNombreEnfermedad().equals("VIH SIDA")) {
                    sida = c.getNombreArchivo();
                }

            }
            if (sida == null || sida.isEmpty() || gon == null || gon.isEmpty() || her == null || her.isEmpty() || sif == null || sif.isEmpty()
                    || tri == null || tri.isEmpty() || cla == null || cla.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Tiene que subir todos los certificados"));
            } else if (suscripcionCliente.crearSolicitud(String.valueOf(usuario.getId()), usuario.getEmail(),
                    usuario.getNickname(), " ", usuario.getGenero(), sida, gon, sif, her, cla, tri).equals("true")) {
                BeanUtils.copyProperties(sessionBean.getUser(), this.usuario);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud Enviada con Éxito", null));
                this.usuario.setPremium("P");
                usuarioServicio.editarPerfil(usuario);

            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se ha aceptado su solicitud"));
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));

        }
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

    public void handleFileUpload(FileUploadEvent event) {

        file = event.getFile();
        FacesMessage message = new FacesMessage("Imagen ", file.getFileName() + " cargada correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        fileName = file.getFileName();
    }

    public void actualizarEnfermedadSeleccionada() {
        for (Certificado c : certificadosUsuario) {
            if (c.getTipoCertificado().getNombreEnfermedad().equals(enfermedadSeleccionada)) {
                certificadoSeleccionado = c;
                cancelFileUpload();
                System.out.println("la enfermedad cambio");
                break;
            }
        }
    }

}

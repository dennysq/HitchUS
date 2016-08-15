/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.model.CalificacionEncuentro;
import com.teamj.arquitectura.hitchus.model.Encuentro;
import com.teamj.arquitectura.hitchus.services.EncuentroServicio;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Dennys
 */
@ViewScoped
@ManagedBean
public class EncuentrosBean implements Serializable {

    @EJB
    UsuarioServicio usuarioServicio;
    @EJB
    EncuentroServicio encuentroServicio;

    private Integer numeroPersonas;
    private Integer numeroHabitaciones;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String ciudad;
    private Boolean conDesayuno;
    private List<String> ciudades;
    private List<Encuentro> encuentros;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    private CalificacionEncuentro calificacionEncuentro;
    private Encuentro encuentroSeleccionado;

    @PostConstruct
    public void init() {
        ciudades = new ArrayList<>();
        ciudades.add("Guayaquil");
        ciudades.add("Manta");
        numeroHabitaciones = 1;
        numeroPersonas = 1;
        fechaEntrada = new Date();

        encuentros = usuarioServicio.obtenerEncuentrosPorUsuario(sessionBean.getUser());

    }

    public void setEncuentroSeleccionado(Encuentro encuentroSeleccionado) {
        this.encuentroSeleccionado = encuentroSeleccionado;
    }

    public Encuentro getEncuentroSeleccionado() {
        return encuentroSeleccionado;
    }

    public void setCalificacionEncuentro(CalificacionEncuentro calificacionEncuentro) {
        this.calificacionEncuentro = calificacionEncuentro;
    }

    public CalificacionEncuentro getCalificacionEncuentro() {

        return calificacionEncuentro;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public List<Encuentro> getEncuentros() {
        return encuentros;
    }

    public void setEncuentros(List<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }

    public String todayDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    }

    public void setCiudades(List<String> ciudades) {
        this.ciudades = ciudades;
    }

    public List<String> getCiudades() {
        return ciudades;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Boolean getConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(Boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Row State " + event.getVisibility(),
                "State:" + ((Encuentro) event.getData()).getEstado());
        encuentroSeleccionado = ((Encuentro) event.getData());
        if (encuentroSeleccionado.getCalificacionEncuentros() != null && !encuentroSeleccionado.getCalificacionEncuentros().isEmpty()) {
            for (CalificacionEncuentro ce : encuentroSeleccionado.getCalificacionEncuentros()) {
                if (ce.getUsuario().equals(sessionBean.getUser())) {
                    this.calificacionEncuentro = ce;
                    System.out.println("hola");
                    break;
                }
            }
        } else {
            System.out.println("hola2");
            this.calificacionEncuentro = new CalificacionEncuentro();
            this.calificacionEncuentro.setAmabilidad(BigDecimal.ZERO);
            this.calificacionEncuentro.setGeneral(BigDecimal.ZERO);
            this.calificacionEncuentro.setComportamiento(BigDecimal.ZERO);
            this.calificacionEncuentro.setHigiene(BigDecimal.ONE);
        }
        //    FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void actualizarCalificacion() {
        int index = encuentros.indexOf(encuentroSeleccionado);
        System.out.println("" + index);
        int numeroUsuario = 1;
        if (encuentroSeleccionado.getUsuario1().getEmail().equals(sessionBean.getUser().getEmail())) {
            numeroUsuario = 1;
            encuentros.get(index).setCalificacionPromedio1(new BigDecimal((calificacionEncuentro.getAmabilidadInt() + calificacionEncuentro.getComportamientoInt() + calificacionEncuentro.getGeneralInt() + calificacionEncuentro.getHigieneInt()) / 4));
        } else {
            numeroUsuario = 2;
            encuentros.get(index).setCalificacionPromedio2(new BigDecimal((calificacionEncuentro.getAmabilidadInt() + calificacionEncuentro.getComportamientoInt() + calificacionEncuentro.getGeneralInt() + calificacionEncuentro.getHigieneInt()) / 4));
        }
        calificacionEncuentro.setAmabilidad(new BigDecimal(calificacionEncuentro.getAmabilidadInt()));
        calificacionEncuentro.setComportamiento(new BigDecimal(calificacionEncuentro.getComportamientoInt()));
        calificacionEncuentro.setGeneral(new BigDecimal(calificacionEncuentro.getGeneralInt()));
        calificacionEncuentro.setHigiene(new BigDecimal(calificacionEncuentro.getHigieneInt()));
        encuentroServicio.actualizarCalificacion(calificacionEncuentro, numeroUsuario);
    }

    public String nombreHitch(Encuentro e) {
        if (e.getUsuario1().getEmail().equals(sessionBean.getUser().getEmail())) {
            return e.getUsuario2().getNickname();
        } else {
            return e.getUsuario1().getNickname();
        }

    }

    public String estadoEncuentro(Encuentro e) {
        if (e.getEstado().equals("NRE")) {
            return "No Realizado";
        } else {
            return "Realizado";
        }

    }

    public BigDecimal calificacionUsuarioEncuentro(Encuentro e) {
        if (e.getUsuario1().getEmail().equals(sessionBean.getUser().getEmail())) {
            return e.getCalificacionPromedio1();
        } else {
            return e.getCalificacionPromedio2();
        }

    }
}

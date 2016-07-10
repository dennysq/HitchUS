/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.hitchus.model.Encuentro;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
public class EncuentrosBean implements Serializable {

    @EJB
    UsuarioServicio usuarioServicio;

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

}
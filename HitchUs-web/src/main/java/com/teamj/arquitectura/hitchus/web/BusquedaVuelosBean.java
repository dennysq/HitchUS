/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.web;

import com.teamj.arquitectura.travelit.services.AerolineasServicios;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.faces.context.FacesContext;
import localhost._50445.PrincipalRespuesta;
import localhost._50445.PrincipalRespuestaReserva;

/**
 *
 * @author Dennys
 */
@ViewScoped
@ManagedBean
public class BusquedaVuelosBean implements Serializable {

    @EJB
    AerolineasServicios aerolineasServicios;
    private PrincipalRespuestaReserva respuestaReserva;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    public PrincipalRespuestaReserva getRespuestaReserva() {
        return respuestaReserva;
    }

    public void setRespuestaReserva(PrincipalRespuestaReserva respuestaReserva) {
        this.respuestaReserva = respuestaReserva;
    }
    private Integer numeroAsientos;
    private Date fechaRetorno;
    private Date fechaSalida;
    private String ciudadOrigen;
    private String ciudadDestino;
    private List<String> ciudadesOrigen;
    private List<String> ciudadesDestino;
    private BigDecimal cotizacion;
    private List<PrincipalRespuesta> result;

//
    @PostConstruct
    public void init() {
        ciudadesOrigen = new ArrayList<>();
        ciudadesOrigen.add("Guayaquil");
        ciudadesOrigen.add("Manta");
        ciudadesOrigen.add("Quito");
        ciudadesDestino = new ArrayList<>();
        ciudadesDestino.add("Guayaquil");
        ciudadesDestino.add("Manta");
        ciudadesDestino.add("Quito");

        numeroAsientos = 1;
        fechaSalida = new Date();
        fechaRetorno = new Date();

    }

    public String todayDate() {//Pero no nos da la consulta 
        return new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }

    public Integer getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(Integer numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public List<String> getCiudadesOrigen() {
        return ciudadesOrigen;
    }

    public void setCiudadesOrigen(List<String> ciudadesOrigen) {
        this.ciudadesOrigen = ciudadesOrigen;
    }

    public List<String> getCiudadesDestino() {
        return ciudadesDestino;
    }

    public void setCiudadesDestino(List<String> ciudadesDestino) {
        this.ciudadesDestino = ciudadesDestino;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void buscar() {//aqui si esta bien
        result = aerolineasServicios.consultar(new SimpleDateFormat("yyyy-MM-dd").format(fechaSalida), new SimpleDateFormat("yyyy-MM-dd").format(fechaRetorno), numeroAsientos, ciudadOrigen, ciudadDestino);
        System.out.println("datos:" + result);
        if (result == null || result.isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta", "No se han encontrado resultados");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public BigDecimal getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(BigDecimal cotizacion) {
        this.cotizacion = cotizacion;
    }

    public List<PrincipalRespuesta> getResult() {
        return result;
    }

    public void setResult(List<PrincipalRespuesta> result) {
        this.result = result;
    }

    public void reservar(PrincipalRespuesta reserva) {
        String msgString = aerolineasServicios.reservar(reserva.getCodigoAerolinea(), reserva.getCodigoVuelo(), reserva.getNombreAerolinea(), reserva.getCotizacion(), reserva.getFechaSalida(), reserva.getFechaLlegada(), this.numeroAsientos, this.ciudadOrigen, this.ciudadDestino, sessionBean.getUser().getIdentificacion(), sessionBean.getUser().getNombre());

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva", msgString);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}

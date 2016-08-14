/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.nosql.model;

import com.teamj.arquitectura.hitchus.nosql.persistence.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author Dennys
 */
@Entity(noClassnameStored = true)
public class Usuario extends BaseEntity implements Serializable {

    private Integer idUsuario;

    private String nickname;

    private String password;

    private String email;

    private Integer anioNacimiento;

    private Integer mesNacimiento;

    private Float estatura;

    private Boolean trabajo;

    private String premium;

    private String numeroTelefonico;

    private String estado;

    private Float calificacion;

    private String genero;

    private String intereses;

    private String contextura;

    private String nivelEducacion;

    private String idiomas;

    private Float peso;

    

    private Boolean enfermedadesPublica;

    private String paisOrigen;

    private String ciudadResidencia;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(Integer mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public Float getEstatura() {
        return estatura;
    }

    public void setEstatura(Float estatura) {
        this.estatura = estatura;
    }

    public Boolean getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Boolean trabajo) {
        this.trabajo = trabajo;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getContextura() {
        return contextura;
    }

    public void setContextura(String contextura) {
        this.contextura = contextura;
    }

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    
    public Boolean getEnfermedadesPublica() {
        return enfermedadesPublica;
    }

    public void setEnfermedadesPublica(Boolean enfermedadesPublica) {
        this.enfermedadesPublica = enfermedadesPublica;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nickname=" + nickname + ", password=" + password + ", email=" + email + ", anioNacimiento=" + anioNacimiento + ", mesNacimiento=" + mesNacimiento + ", estatura=" + estatura + ", trabajo=" + trabajo + ", premium=" + premium + ", numeroTelefonico=" + numeroTelefonico + ", estado=" + estado + ", calificacion=" + calificacion + ", genero=" + genero + ", intereses=" + intereses + ", contextura=" + contextura + ", nivelEducacion=" + nivelEducacion + ", idiomas=" + idiomas + ", peso=" + peso + ", enfermedadesPublica=" + enfermedadesPublica + ", paisOrigen=" + paisOrigen + ", ciudadResidencia=" + ciudadResidencia + '}';
    }

   

}

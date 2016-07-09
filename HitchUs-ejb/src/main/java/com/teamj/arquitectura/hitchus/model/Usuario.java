/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Dennys
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NICKNAME")
    private String nickname;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "ANIO_NACIMIENTO")
    private Integer anio_nacimiento;
    
    @Column(name = "MES_NACIMIENTO")
    private Integer mes_nacimiento;

    @Column(name = "ESTATURA")
    private BigDecimal estatura;
    
    @Column(name = "TRABAJO")
    private String trabajo;
    
    @Column(name = "PREMIUM")
    private String premium;
    
    @Column(name = "NUMERO_TELEFONICO")
    private String numero_telefonico;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "CALIFICACION")
    private BigDecimal calificacion;
    
    @Column(name = "GENERO")
    private String genero;
    
    @Column(name = "INTERESES")
    private String intereses;
    
    @Column(name = "CONTEXTURA")
    private String contextura;
    
    @Column(name = "NIVEL_EDUCACION")
    private String nivel_educacion;

    @Column(name = "IDIOMAS")
    private String idiomas;
    
    @Column(name = "PESO")
    private BigDecimal peso;
       
    @Column(name = "CREADO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creado;
    
    @Column(name = "ENFERMEDADES_PUBLICA")
    private String enfermedades_publica;

    public Usuario() {
    }

    public Usuario(String nickname, String password, String email, Integer anio_nacimiento, Integer mes_nacimiento, BigDecimal estatura, String trabajo, String premium, String numero_telefonico, String estado, BigDecimal calificacion, String genero, String intereses, String contextura, String nivel_educacion, String idiomas, BigDecimal peso, Date creado, String enfermedades_publica) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.anio_nacimiento = anio_nacimiento;
        this.mes_nacimiento = mes_nacimiento;
        this.estatura = estatura;
        this.trabajo = trabajo;
        this.premium = premium;
        this.numero_telefonico = numero_telefonico;
        this.estado = estado;
        this.calificacion = calificacion;
        this.genero = genero;
        this.intereses = intereses;
        this.contextura = contextura;
        this.nivel_educacion = nivel_educacion;
        this.idiomas = idiomas;
        this.peso = peso;
        this.creado = creado;
        this.enfermedades_publica = enfermedades_publica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAnio_nacimiento() {
        return anio_nacimiento;
    }

    public void setAnio_nacimiento(Integer anio_nacimiento) {
        this.anio_nacimiento = anio_nacimiento;
    }

    public Integer getMes_nacimiento() {
        return mes_nacimiento;
    }

    public void setMes_nacimiento(Integer mes_nacimiento) {
        this.mes_nacimiento = mes_nacimiento;
    }

    public BigDecimal getEstatura() {
        return estatura;
    }

    public void setEstatura(BigDecimal estatura) {
        this.estatura = estatura;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getNumero_telefonico() {
        return numero_telefonico;
    }

    public void setNumero_telefonico(String numero_telefonico) {
        this.numero_telefonico = numero_telefonico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
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

    public String getNivel_educacion() {
        return nivel_educacion;
    }

    public void setNivel_educacion(String nivel_educacion) {
        this.nivel_educacion = nivel_educacion;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public String getEnfermedades_publica() {
        return enfermedades_publica;
    }

    public void setEnfermedades_publica(String enfermedades_publica) {
        this.enfermedades_publica = enfermedades_publica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email + ", anio_nacimiento=" + anio_nacimiento + ", mes_nacimiento=" + mes_nacimiento + ", estatura=" + estatura + ", trabajo=" + trabajo + ", premium=" + premium + ", numero_telefonico=" + numero_telefonico + ", estado=" + estado + ", calificacion=" + calificacion + ", genero=" + genero + ", intereses=" + intereses + ", contextura=" + contextura + ", nivel_educacion=" + nivel_educacion + ", idiomas=" + idiomas + ", peso=" + peso + ", creado=" + creado + ", enfermedades_publica=" + enfermedades_publica + '}';
    }
    
}

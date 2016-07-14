/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import com.teamj.arquitectura.hitchus.converter.BooleanToStringConverter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
    @SequenceGenerator(name = "USUARIO_ID", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USUARIO_ID")
    @Column(name = "ID_USUARIO")
    private Integer id;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ANIO_NACIMIENTO")
    private Integer anioNacimiento;

    @Column(name = "MES_NACIMIENTO")
    private Integer mesNacimiento;

    @Column(name = "ESTATURA")
    private BigDecimal estatura;

    @Column(name = "TRABAJO")
    @Convert(converter = BooleanToStringConverter.class)
    private Boolean trabajo;

    @Column(name = "PREMIUM")
    private String premium;

    @Column(name = "NUMERO_TELEFONO")
    private String numeroTelefonico;

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
    private String nivelEducacion;

    @Column(name = "IDIOMAS")
    private String idiomas;

    @Column(name = "PESO")
    private BigDecimal peso;

    @Column(name = "CREADO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creado;

    @Column(name = "ENFERMEDADES_PUBLICA")
    @Convert(converter = BooleanToStringConverter.class)
    private Boolean enfermedadesPublica;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS_ORIGEN")
    private PaisOrigen paisOrigen;

    @ManyToOne
    @JoinColumn(name = "ID_CIUDAD_RESIDENCIA")
    private CiudadResidencia ciudadResidencia;

    @OneToMany(mappedBy = "usuario1", targetEntity = Encuentro.class,
            fetch = FetchType.LAZY)
    List<Encuentro> encuentros;

    public Usuario() {
    }

    public Usuario(String nickname, String password, String email, Integer anioNacimiento, Integer mesNacimiento, BigDecimal estatura, Boolean trabajo, String premium, String numeroTelefonico, String estado, BigDecimal calificacion, String genero, String intereses, String contextura, String nivelEducacion, String idiomas, BigDecimal peso, Date creado, Boolean enfermedadesPublica) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.anioNacimiento = anioNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.estatura = estatura;
        this.trabajo = trabajo;
        this.premium = premium;
        this.numeroTelefonico = numeroTelefonico;
        this.estado = estado;
        this.calificacion = calificacion;
        this.genero = genero;
        this.intereses = intereses;
        this.contextura = contextura;
        this.nivelEducacion = nivelEducacion;
        this.idiomas = idiomas;
        this.peso = peso;
        this.creado = creado;
        this.enfermedadesPublica = enfermedadesPublica;
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

    public BigDecimal getEstatura() {
        return estatura;
    }

    public void setEstatura(BigDecimal estatura) {
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

    public Boolean getEnfermedadesPublica() {
        return enfermedadesPublica;
    }

    public void setEnfermedadesPublica(Boolean enfermedadesPublica) {
        this.enfermedadesPublica = enfermedadesPublica;
    }

    

    public PaisOrigen getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(PaisOrigen paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public CiudadResidencia getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(CiudadResidencia ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        return "Usuario{" + "id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email + ", anioNacimiento=" + anioNacimiento + ", mesNacimiento=" + mesNacimiento + ", estatura=" + estatura + ", trabajo=" + trabajo + ", premium=" + premium + ", numeroTelefonico=" + numeroTelefonico + ", estado=" + estado + ", calificacion=" + calificacion + ", genero=" + genero + ", intereses=" + intereses + ", contextura=" + contextura + ", nivelEducacion=" + nivelEducacion + ", idiomas=" + idiomas + ", peso=" + peso + ", creado=" + creado + ", enfermedadesPublica=" + enfermedadesPublica + '}';
    }
}

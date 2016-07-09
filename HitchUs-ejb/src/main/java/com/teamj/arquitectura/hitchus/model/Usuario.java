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
    
//    @OneToMany(mappedBy = "usuario", targetEntity = Encuentro.class,
//            fetch = FetchType.LAZY)
//    List<Encuentro> encuentros;
//    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public Date getFechaNacimiento() {
//        return fechaNacimiento;
//    }
//
//    public void setFechaNacimiento(Date fechaNacimiento) {
//        this.fechaNacimiento = fechaNacimiento;
//    }
//
//    public BigDecimal getEstatura() {
//        return estatura;
//    }
//
//    public void setEstatura(BigDecimal estatura) {
//        this.estatura = estatura;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 17 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Usuario other = (Usuario) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", estatura=" + estatura + '}';
//    }

}

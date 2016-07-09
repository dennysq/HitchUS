/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "CERTIFICADO")
public class Certificado implements Serializable{
    
    @Id
    @Column(name = "ID_ENTIDAD_CERTIFICADORA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "PATH")
    private String path;
    
    @Column(name = "FECHA_RECEPCION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_recepcion;
    
    @Column(name = "FECHA_VALIDACION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_validacion;
    
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_caducidad;
    
    @Column(name = "RESULTADO")
    private String resultado;
    
    @Column(name = "VERIFICADO")
    private String verificado;
}

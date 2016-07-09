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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "MENSAJE")
public class Mensaje implements Serializable{
    
    @Id
    @Column(name = "SEC_MENSAJE")
    private Integer sec_mensaje;
    
    @Column(name = "RECEPTOR")
    private Integer receptor;
    
    @Column(name = "EMISOR")
    private Integer emisor;
    
    @Column(name = "FECHA_ENVIO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_envio;
    
}

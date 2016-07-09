/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ESTADISTICA_USUARIO")
public class Estadistica_Usuario implements Serializable{
    @Id
    @Column(name = "ID_USUARIO")
    private Integer id;
    
    @Column(name = "HIGIENE")
    private BigDecimal higiene;
    
    @Column(name = "COMPORTAMIENTO")
    private BigDecimal comportamiento;
    
    @Column(name = "AMABILIDAD")
    private BigDecimal amabilidad;
    
    @Column(name = "GENERAL")
    private BigDecimal general;
    
    @Column(name = "BLOQUEOS")
    private Integer Bloqueos;
    
    @Column(name = "PROMEDIO_ACTUAL")
    private BigDecimal promedio_actual;
    
    @Column(name = "SOLICITUDES_ENVIADAS")
    private Integer solicitudes_enviadas;
    
    @Column(name = "SOLICITUDES_RECIBIDAS")
    private Integer solicitudes_recibidas;
    
    @Column(name = "MENSAJES_ENVIADOS")
    private Integer mensajes_enviados;
    
    @Column(name = "MENSAJES_RECIBIDOS")
    private Integer mensajes_recibidos;
    
    @Column(name = "ULTIMA_ACTUALIZACION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ultima_actualizacion;
}

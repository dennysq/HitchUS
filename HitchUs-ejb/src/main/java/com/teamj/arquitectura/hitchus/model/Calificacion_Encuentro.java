/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "CALIFICACION_USUARIO")
public class Calificacion_Encuentro implements Serializable{

    @Id
    @Column(name = "ID_USUARIO")
    private Integer id_usuario;
    
    @Column(name = "ID_ENCUENTRO")
    private Integer id_encuentro;
    
    @Column(name = "HIGIENE")
    private BigDecimal higiene;
    
    @Column(name = "COMPORTAMIENTO")
    private BigDecimal comportamiento;
    
    @Column(name = "AMABILIDAD")
    private BigDecimal amabilidad;
    
    @Column(name = "GENERAL")
    private BigDecimal general;
    
}

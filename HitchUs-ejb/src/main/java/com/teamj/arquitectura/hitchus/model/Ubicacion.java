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
@Table(name = "UBICACION")
public class Ubicacion implements Serializable{
    @Id
    @Column(name = "FECHA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fecha;
    
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
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
@Table(name = "TIPO_CERTIFICADO")
public class Tipo_Certificado implements Serializable{
    
    @Id
    @Column(name = "ID_TIPO_CERTIFICADO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NOMBRE_CERTIFICADO")
    private String nombre_certificado;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "TIEMPO_VALIDEZ")
    private Integer tiempo_validez;
    
    @Column(name = "NOMBRE_ENFERMEDAD")
    private String nombre_enfermedad;
    
}

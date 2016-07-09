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
@Table(name = "CIUDAD_RESIDENCIA")
public class Ciudad_Residencia implements Serializable{
    @Id
    @Column(name = "ID_CIUDAD_RESIDENCIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "Ciudad")
    private String pais;
}

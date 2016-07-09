/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "BLOQUEO")
public class Bloqueo implements Serializable{
    
    @EmbeddedId
    BloqueoPK bloqueoPK;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO1", nullable = false,insertable = false,updatable = false)
    private Usuario vuelo;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO2", nullable = false,insertable = false,updatable = false)
    
    @Column(name = "DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
}

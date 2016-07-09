/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
    private Usuario usuario1;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO2", nullable = false,insertable = false,updatable = false)
    private Usuario usuario2;
    
    @Column(name = "DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;

    public Bloqueo() {
    }

    public BloqueoPK getBloqueoPK() {
        return bloqueoPK;
    }

    public void setBloqueoPK(BloqueoPK bloqueoPK) {
        this.bloqueoPK = bloqueoPK;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.bloqueoPK);
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
        final Bloqueo other = (Bloqueo) obj;
        if (!Objects.equals(this.bloqueoPK, other.bloqueoPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bloqueo{" + "bloqueoPK=" + bloqueoPK + ", usuario1=" + usuario1 + ", usuario2=" + usuario2 + ", date=" + date + '}';
    }
    
    
}

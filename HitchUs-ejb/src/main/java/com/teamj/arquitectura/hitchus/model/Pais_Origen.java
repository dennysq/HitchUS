/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "PAIS_ORIGEN")
public class Pais_Origen implements Serializable{
    @Id
    @Column(name = "ID_PAIS_ORIGEN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ENCUENTROS")
    private Integer encuentros;

    public Pais_Origen() {
    }

    public Pais_Origen(Integer id, Integer encuentros) {
        this.id = id;
        this.encuentros = encuentros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEncuentros() {
        return encuentros;
    }

    public void setEncuentros(Integer encuentros) {
        this.encuentros = encuentros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Pais_Origen other = (Pais_Origen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pais_Origen{" + "id=" + id + ", encuentros=" + encuentros + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

/**
 *
 * @author Klever
 */
@Embeddable
public class BloqueoPK implements Serializable{

    @Column(name = "ID_USUARIO1")
    private Integer id_usuario1;
     
    @Column(name = "ID_USUARIO2")
    private Integer id_usuario2;
}

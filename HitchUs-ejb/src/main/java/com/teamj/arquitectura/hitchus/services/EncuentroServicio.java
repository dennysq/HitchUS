/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.EncuentroDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author RICARDO
 */
@Stateless
@LocalBean
public class EncuentroServicio implements Serializable{

    @EJB
    private EncuentroDAO encuentroDAO;    

}

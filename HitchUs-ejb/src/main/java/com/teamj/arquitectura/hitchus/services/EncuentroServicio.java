/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.EncuentroDAO;
import com.teamj.arquitectura.hitchus.dao.ImagenDAO;
import com.teamj.arquitectura.hitchus.dao.PaisOrigenDAO;
import com.teamj.arquitectura.hitchus.dao.UsuarioDAO;
import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.model.PaisOrigen;
import com.teamj.arquitectura.hitchus.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.validation.ValidationException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author RICARDO
 */
@Stateless
@LocalBean
public class EncuentroServicio {

    @EJB
    private EncuentroDAO encuentroDAO;    

}

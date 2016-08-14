/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.nosql.services;

import com.teamj.arquitectura.hitchus.exception.ValidationException;
import com.teamj.arquitectura.hitchus.nosql.dao.UsuarioDAO;
import com.teamj.arquitectura.hitchus.nosql.model.Usuario;
import com.teamj.arquitectura.hitchus.nosql.persistence.PersistenceManager;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Dennys
 */
@LocalBean
@Stateless
public class UsuarioMongoServicio {

    UsuarioDAO usuarioDAO;
//    @EJB
//    ClienteServicio clienteServicio;
//

    @PostConstruct
    public void init() {
        this.usuarioDAO = new UsuarioDAO(Usuario.class, PersistenceManager.instance().datastore());
    }
//

    public String createEbankingUser(Usuario user) throws ValidationException {
        try {
            Usuario temp = this.usuarioDAO.findOne("email", user.getEmail());
            if (temp == null) {
                this.usuarioDAO.save(user);
                return "1";
            } else {
                return "2";

            }
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }

    }
//
//    public Usuario login(Usuario u) throws ValidationException {
//        Usuario temp = null;
//        try {
//            Query q = PersistenceManager.instance().datastore().createQuery(Usuario.class)
//                    .filter("nombreUsuario =", u.getNombreUsuario())
//                    .filter("password =", u.getPassword());
//
//            temp = this.usuarioDAO.findOne(q);
//        } catch (Exception e) {
//
//            throw new ValidationException(e.getMessage());
//        }
//        return temp;
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.nosql.dao;

import com.teamj.arquitectura.hitchus.nosql.model.Usuario;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author Dennys
 */

public class UsuarioDAO extends BasicDAO<Usuario, ObjectId> {
   
    public UsuarioDAO(Class<Usuario> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

}

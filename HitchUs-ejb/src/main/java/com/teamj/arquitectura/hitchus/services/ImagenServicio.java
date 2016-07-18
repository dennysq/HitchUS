/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.ImagenDAO;
import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.validation.ValidationException;

/**
 *
 * @author RICARDO
 */
@Stateless
@LocalBean
public class ImagenServicio implements Serializable{

    @EJB
    private ImagenDAO imagenDAO;

    public boolean actualizar(Imagen i) throws ValidationException {
        boolean flag = false;
        try {
            this.imagenDAO.update(i);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar al actualizar", e);
        }
        return flag;
    }
    public void eliminar(Integer id) {
        Imagen temp = this.imagenDAO.findById(id, false);
        if (temp != null) {
            this.imagenDAO.remove(temp);
        }
    }

    public List<Imagen> obtenerImagenesPorUsuario(Usuario u) {
        Imagen temp = new Imagen();
        temp.setUsuario(u);
        return this.imagenDAO.find(temp);
    }
}

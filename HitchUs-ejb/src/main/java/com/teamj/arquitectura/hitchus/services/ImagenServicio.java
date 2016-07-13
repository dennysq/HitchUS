/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.ImagenDAO;
import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.validation.ValidationException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author RICARDO
 */
@Stateless
@LocalBean
public class ImagenServicio {

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

    public void guardarImagen(InputStream input, String path, String name, Usuario usuario, String descripcion, String nombre, boolean publica, boolean perfil) {

        Imagen tempImg = new Imagen();
        tempImg.setPerfil(perfil);
        tempImg.setPublica(publica);
        tempImg.setNombre(nombre);
        tempImg.setDescripcion(descripcion);
        //     tempImg.setUsuario(usuario);
        tempImg.setUrl(path);
        //create destination File
        //String destPath = "your path here";
        this.imagenDAO.insert(tempImg);
        File destFile = new File(path, "" + tempImg.getId()+".jpg");

        //use org.apache.commons.io.FileUtils to copy the File
        try {
            FileUtils.copyInputStreamToFile(input, destFile);

        } catch (IOException e) {
            //log error
        }
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

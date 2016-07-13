/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.ApplicationContext;
import com.teamj.arquitectura.hitchus.dao.CertificadoDAO;
import com.teamj.arquitectura.hitchus.dao.EncuentroDAO;
import com.teamj.arquitectura.hitchus.dao.EntidadCertificadoraDAO;
import com.teamj.arquitectura.hitchus.dao.ImagenDAO;
import com.teamj.arquitectura.hitchus.dao.PaisOrigenDAO;
import com.teamj.arquitectura.hitchus.dao.TipoCertificadoDAO;
import com.teamj.arquitectura.hitchus.dao.UsuarioDAO;
import com.teamj.arquitectura.hitchus.model.Certificado;
import com.teamj.arquitectura.hitchus.model.CertificadoPK;
import com.teamj.arquitectura.hitchus.model.Encuentro;
import com.teamj.arquitectura.hitchus.model.EntidadCertificadora;
import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.model.PaisOrigen;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import com.teamj.arquitectura.hitchus.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
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
public class UsuarioServicio {

    @EJB
    private CertificadoDAO certificadoDAO;
    @EJB
    ApplicationContext applicationContext;
    @EJB
    private TipoCertificadoDAO tipoCertificadoDAO;
    @EJB
    private EntidadCertificadoraDAO entidadCertificadoraDAO;
    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    private EncuentroDAO encuentroDAO;
    @EJB
    private ImagenDAO imagenDAO;
    @EJB
    private PaisOrigenDAO paisDAO;

    public boolean registrar(Usuario u) throws ValidationException {
        boolean flag = false;
        Usuario temp = new Usuario();

        temp.setEmail(u.getEmail());

        List<Usuario> tempList = this.usuarioDAO.find(temp);
        if (tempList == null || tempList.isEmpty()) {//el email de usuario no existe
            try {

                temp.setNickname(u.getNickname());
                temp.setMesNacimiento(u.getMesNacimiento());
                temp.setAnioNacimiento(u.getAnioNacimiento());
                temp.setNumeroTelefonico(u.getNumeroTelefonico());

                temp.setTrabajo("N");

                temp.setPremium("N");
                temp.setEstado("ACT");
                temp.setGenero("MAS");
                temp.setEstatura(BigDecimal.ZERO);
                temp.setEnfermedadesPublica("N");
                temp.setCreado(new Date());
                temp.setIntereses(" ");
                String codecPassword = DigestUtils.md5Hex(u.getPassword());
                temp.setPassword(codecPassword);

                usuarioDAO.insert(temp);

                flag = crearCertificadosPorUsuario(temp);
            } catch (Exception e) {
                throw new ValidationException("Error al crear el nuevo usuario", e);
            }
        }
        return flag;
    }

    public boolean crearCertificadosPorUsuario(Usuario u) {

        List<TipoCertificado> tipoCertificados = tipoCertificadoDAO.findAll();
        Certificado c;
        EntidadCertificadora entidadCertificadora = new EntidadCertificadora();
        entidadCertificadora.setNombre("HitchUS");
        List<EntidadCertificadora> entidadCertificadoras = entidadCertificadoraDAO.find(entidadCertificadora);
        if (entidadCertificadoras.isEmpty()) {
            return false;
        }
        CertificadoPK certificadoPK;
        for (TipoCertificado tipoC : tipoCertificados) {
            certificadoPK = new CertificadoPK();
            certificadoPK.setTipoCertificado(tipoC.getId());
            certificadoPK.setUsuario(u.getId());
            c = new Certificado();
            c.setEntidadCertificadora(entidadCertificadoras.get(0));
            c.setCertificadoPK(certificadoPK);
            c.setVerificado("N");
            certificadoDAO.insert(c);
        }
        System.out.println("Creando certificados para el usuario" + u.getEmail());
        return true;
    }

    public boolean editarPerfil(Usuario u) throws ValidationException {
        boolean flag = false;
        try {
            this.usuarioDAO.update(u);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar el nuevo usuario", e);
        }
        return flag;
    }

    public Usuario ingresar(String emailUsuario, String password) {
        Usuario tempUsu = new Usuario();
        tempUsu.setEmail(emailUsuario);

        List<Usuario> tempList = this.usuarioDAO.find(tempUsu);
        if (tempList != null && tempList.size() == 1) {
            if (DigestUtils.md5Hex(password).equals(tempList.get(0).getPassword())) {
                return tempList.get(0);
            }
        }
        return null;
    }

    public void guardarImagen(InputStream input, String name, Usuario usuario, String descripcion, boolean publica, boolean perfil) {

        Imagen tempImg = new Imagen();
        tempImg.setPerfil(perfil);
        tempImg.setPublica(publica);
        tempImg.setDescripcion(descripcion);
        tempImg.setUsuario(usuario);
        tempImg.setUrl(applicationContext.getImagesPath());
        tempImg.setNombre(name);
        //create destination File

        //use org.apache.commons.io.FileUtils to copy the File
        try {
            this.imagenDAO.insert(tempImg);
            File destFile = new File(tempImg.getUrl(), tempImg.getId() + ".jpg");
            FileUtils.copyInputStreamToFile(input, destFile);

        } catch (IOException e) {
            //log error
            System.out.println("" + e);
        }
    }

    public List<PaisOrigen> obtenerPaises() {
        return this.paisDAO.findAll();
    }

    public void eliminar(Integer id) {
        Usuario temp = this.usuarioDAO.findById(id, false);
        if (temp != null) {
            this.usuarioDAO.remove(temp);
        }
    }

//    public boolean actualizar(Usuario u) throws ValidationException {
//        boolean flag = false;
//        try {
//            Usuario userToUpdate = this.usuarioDAO.findById(u.getId(), false);
//            if (userToUpdate != null) {
//                userToUpdate.setActivo(u.getActivo());
//                userToUpdate.setNombre(u.getNombre());
//                //el passoword no voy a tomar en cuenta
//                userToUpdate.setEmail(u.getEmail());
//                this.usuarioDAO.update(userToUpdate);
//            }
//            flag = true;
//
//        } catch (Exception e) {
//            throw new ValidationException(e, "Error  al actualizar el usuario");
//        }
//
//        return flag;
//    }
//
//    public boolean cambiarContraseña(Usuario u, String oldP, String newP, String reNewP) throws ValidationException {
//        boolean flag = false;
//        try {
//            if (DigestUtils.md5Hex(oldP).equals(u.getClave()) && newP.equals(reNewP)) {
//                u.setClave(DigestUtils.md5Hex(newP));
//                this.usuarioDAO.update(u);
//                flag = true;
//            }
//        } catch (Exception e) {
//            throw new ValidationException(e, "Error  al actualizar el usuario");
//        }
//        return flag;
//    }
    public boolean cambiarContraseña(Usuario user, String oldPassword, String newPassword, String reNewPassword) throws ValidationException {
        boolean flag = false;
        try {
            if (DigestUtils.md5Hex(oldPassword).equals(user.getPassword()) && newPassword.equals(reNewPassword)) {
                user.setPassword(DigestUtils.md5Hex(newPassword));
                this.usuarioDAO.update(user);
                flag = true;
            }
        } catch (Exception e) {
            throw new ValidationException("Error  al actualizar el usuario", e);
        }
        return flag;
    }

    public List<Encuentro> obtenerEncuentrosPorUsuario(Usuario u) {
        Encuentro temp = new Encuentro();
        temp.setUsuario1(u);
        return this.encuentroDAO.find(temp);
    }

    public List<Imagen> obtenerImagenesPorUsuario(Usuario u) {
        Imagen temp = new Imagen();
        temp.setUsuario(u);
        return this.imagenDAO.find(temp);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.CertificadoDAO;
import com.teamj.arquitectura.hitchus.dao.CiudadResidenciaDAO;
import com.teamj.arquitectura.hitchus.dao.EncuentroDAO;
import com.teamj.arquitectura.hitchus.dao.EntidadCertificadoraDAO;
import com.teamj.arquitectura.hitchus.dao.ImagenDAO;
import com.teamj.arquitectura.hitchus.dao.PaisOrigenDAO;
import com.teamj.arquitectura.hitchus.dao.TipoCertificadoDAO;
import com.teamj.arquitectura.hitchus.dao.UsuarioDAO;
import com.teamj.arquitectura.hitchus.model.Certificado;
import com.teamj.arquitectura.hitchus.model.CertificadoPK;
import com.teamj.arquitectura.hitchus.model.CiudadResidencia;
import com.teamj.arquitectura.hitchus.model.Encuentro;
import com.teamj.arquitectura.hitchus.model.EntidadCertificadora;
import com.teamj.arquitectura.hitchus.model.Imagen;
import com.teamj.arquitectura.hitchus.model.PaisOrigen;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.nosql.persistence.PersistenceManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.validation.ValidationException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author RICARDO
 */
@Stateless
@LocalBean
public class UsuarioServicio implements Serializable {

    @EJB
    private CertificadoDAO certificadoDAO;

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

    @EJB
    private CiudadResidenciaDAO ciudadDAO;

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

                temp.setTrabajo(false);

                temp.setPremium("N");
                temp.setEstado("ACT");
                temp.setGenero("MAS");
                temp.setEstatura(BigDecimal.ZERO);
                temp.setPeso(BigDecimal.ZERO);
                temp.setEnfermedadesPublica(false);

                temp.setCreado(Calendar.getInstance(TimeZone.getTimeZone("ECT")).getTime());

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
            c.setVerificado(false);
            certificadoDAO.insert(c);
        }
        System.out.println("Creando certificados para el usuario" + u.getEmail());
        return true;
    }

    public boolean crearCertificadosPorUsuario2(Usuario u) {
        Certificado ejemploCertificado = new Certificado();
        ejemploCertificado.setUsuario(u);

        List<Certificado> certificados = certificadoDAO.find(ejemploCertificado);
        if (certificados == null || certificados.isEmpty()) {
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
                c.setVerificado(false);
                certificadoDAO.insert(c);
            }
            System.out.println("Creando certificados para el usuario" + u.getEmail());
        }
        return true;
    }

    public boolean editarPerfil(Usuario u) throws ValidationException {
        boolean flag = false;
        try {
            this.usuarioDAO.update(u);

            System.out.println("actualizando en mongo");
            com.teamj.arquitectura.hitchus.nosql.dao.UsuarioDAO usuarioDAO = new com.teamj.arquitectura.hitchus.nosql.dao.UsuarioDAO(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class, PersistenceManager.instance().datastore());
            // com.teamj.arquitectura.hitchus.nosql.model.Usuario user = new com.teamj.arquitectura.hitchus.nosql.model.Usuario();
            com.teamj.arquitectura.hitchus.nosql.model.Usuario user = usuarioDAO.findOne("idUsuario", u.getId());
            if (user != null) {
                Query<com.teamj.arquitectura.hitchus.nosql.model.Usuario> query = PersistenceManager.instance().datastore().createQuery(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class).field("idUsuario").equal(u.getId());
                UpdateOperations<com.teamj.arquitectura.hitchus.nosql.model.Usuario> ops;
                if (u.getCiudadResidencia() != null && u.getPaisOrigen() != null) {
                    ops = PersistenceManager.instance().datastore()
                            .createUpdateOperations(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class)
                            .set("anioNacimiento", u.getAnioNacimiento())
                            .set("calificacion", u.getCalificacion() == null ? 0.0f : u.getCalificacion().floatValue())
                            .set("contextura", u.getContextura() == null ? "" : u.getContextura())
                            .set("enfermedadesPublica", u.getEnfermedadesPublica())
                            .set("estado", u.getEstado() == null ? "" : u.getEstado())
                            .set("estatura", u.getEstatura() == null ? 0.0f : u.getEstatura().floatValue())
                            .set("genero", u.getGenero() == null ? "" : u.getGenero())
                            .set("idiomas", u.getIdiomas() == null ? "" : u.getIdiomas())
                            .set("intereses", u.getIntereses() == null ? "" : u.getIntereses())
                            .set("mesNacimiento", u.getMesNacimiento())
                            .set("nickname", u.getNickname() == null ? "" : u.getNickname())
                            .set("nivelEducacion", u.getNivelEducacion() == null ? "" : u.getNivelEducacion())
                            .set("numeroTelefonico", u.getNumeroTelefonico() == null ? "" : u.getNumeroTelefonico())
                            .set("password", u.getPassword())
                            .set("peso", u.getPeso() == null ? 0.0f : u.getPeso().floatValue())
                            .set("premium", u.getPremium() == null ? "" : u.getPremium())
                            .set("ciudadResidencia", u.getCiudadResidencia().getNombre())
                            .set("paisOrigen", u.getPaisOrigen().getNombre())
                            .set("trabajo", u.getTrabajo() == null ? "" : u.getTrabajo());

                } else {
                    ops = PersistenceManager.instance().datastore()
                            .createUpdateOperations(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class)
                            .set("anioNacimiento", u.getAnioNacimiento())
                            .set("calificacion", u.getCalificacion() == null ? 0.0f : u.getCalificacion().floatValue())
                            .set("contextura", u.getContextura() == null ? "" : u.getContextura())
                            .set("enfermedadesPublica", u.getEnfermedadesPublica())
                            .set("estado", u.getEstado() == null ? "" : u.getEstado())
                            .set("estatura", u.getEstatura() == null ? 0.0f : u.getEstatura().floatValue())
                            .set("genero", u.getGenero() == null ? "" : u.getGenero())
                            .set("idiomas", u.getIdiomas() == null ? "" : u.getIdiomas())
                            .set("intereses", u.getIntereses() == null ? "" : u.getIntereses())
                            .set("mesNacimiento", u.getMesNacimiento())
                            .set("nickname", u.getNickname() == null ? "" : u.getNickname())
                            .set("nivelEducacion", u.getNivelEducacion() == null ? "" : u.getNivelEducacion())
                            .set("numeroTelefonico", u.getNumeroTelefonico() == null ? "" : u.getNumeroTelefonico())
                            .set("password", u.getPassword())
                            .set("peso", u.getPeso() == null ? 0.0f : u.getPeso().floatValue())
                            .set("premium", u.getPremium() == null ? "" : u.getPremium())
                            .set("trabajo", u.getTrabajo() == null ? "" : u.getTrabajo());
                }
                //com.teamj.arquitectura.hitchus.nosql.model.Usuario temp = usuarioDAO.findOne("email", user.getEmail());
                //if (temp == null) {
                usuarioDAO.update(query, ops);
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("error" + e);
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
                usuarioDAO.refresh(tempList.get(0));
                boolean men = crearCertificadosPorUsuario2(tempList.get(0));
                System.out.println("resultado de crear certificados por usuarios:" + men);
                return tempList.get(0);
            }
        }
        return null;
    }

    public void guardarImagen(InputStream input, String path, String name, Usuario usuario, String descripcion, boolean publica, boolean perfil) {

        Imagen tempImg = new Imagen();
        tempImg.setPerfil(perfil);
        tempImg.setPublica(publica);
        tempImg.setDescripcion(descripcion);
        tempImg.setUsuario(usuario);
        tempImg.setUrl(path);
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
        List<Encuentro> encuentros = this.encuentroDAO.find(temp);
        Encuentro temp2 = new Encuentro();
        temp2.setUsuario2(u);
        List<Encuentro> encuentros2 = this.encuentroDAO.find(temp2);
        encuentros.addAll(encuentros2);
        return encuentros;
    }

    public List<Imagen> obtenerImagenesPorUsuario(Usuario u) {
        Imagen temp = new Imagen();
        temp.setUsuario(u);
        return this.imagenDAO.find(temp);
    }

    public Imagen obtenerImagenPerfil(Usuario u) {
        Imagen temp = new Imagen();
        temp.setUsuario(u);
        temp.setPerfil(Boolean.TRUE);
        List<Imagen> imagenes = this.imagenDAO.find(temp);
        if (imagenes != null && !imagenes.isEmpty()) {
            return imagenes.get(0);
        }
        return null;
    }

    public List<CiudadResidencia> obtenerCiudades() {
        return this.ciudadDAO.findAll();
    }

    public Usuario getCurrentUser(Integer id) {
        return this.usuarioDAO.findById(id, true);
    }
}

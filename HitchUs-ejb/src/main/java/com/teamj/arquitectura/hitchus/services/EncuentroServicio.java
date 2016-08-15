/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.services;

import com.teamj.arquitectura.hitchus.dao.CalificacionEncuentroDAO;
import com.teamj.arquitectura.hitchus.dao.EncuentroDAO;
import com.teamj.arquitectura.hitchus.dao.UsuarioDAO;
import com.teamj.arquitectura.hitchus.exception.ValidationException;
import com.teamj.arquitectura.hitchus.model.CalificacionEncuentro;
import com.teamj.arquitectura.hitchus.model.CalificacionEncuentroPK;
import com.teamj.arquitectura.hitchus.model.Encuentro;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.util.StringSimilarity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author RICARDO
 */
@Stateless
@LocalBean
public class EncuentroServicio implements Serializable {

    @EJB
    private EncuentroDAO encuentroDAO;
    @EJB
    private CalificacionEncuentroDAO calificacionEncuentroDAO;
    @EJB
    private UsuarioDAO usuarioDAO;

    public Encuentro crearEncuentro(int idUsuario1, int idUsuario2) throws ValidationException {
        try {
            Usuario user1 = usuarioDAO.findById(idUsuario1, false);
            Usuario user2 = usuarioDAO.findById(idUsuario2, false);
            Encuentro encuentro = new Encuentro();
            encuentro.setUsuario1(user1);
            encuentro.setUsuario2(user2);
            encuentro.setFechaCreacion(new Date());
            encuentro.setUltimaFecha(new Date());
            encuentro.setEstado("NRE");
            encuentro.setAceptaMatch2("N");
            encuentro.setAceptaMatch1("N");
            encuentro.setCalificacionPromedio1(BigDecimal.ZERO);
            encuentro.setCalificacionPromedio2(BigDecimal.ZERO);
            double sim = calcularNivelDeCompatibilidad(user1.getIntereses(), user2.getIntereses());
            encuentro.setNivelCompatibilidad1(new BigDecimal(sim).setScale(2, RoundingMode.HALF_UP));
            encuentro.setNivelCompatibilidad2(new BigDecimal(sim).setScale(2, RoundingMode.HALF_UP));
            encuentroDAO.insert(encuentro);

            CalificacionEncuentro calificacionEncuentro1 = new CalificacionEncuentro();
            CalificacionEncuentroPK calificacionEncuentroPK1 = new CalificacionEncuentroPK(encuentro.getId(), user1.getId());
            calificacionEncuentro1.setCalificacionEncuentroPK(calificacionEncuentroPK1);
            calificacionEncuentro1.setAmabilidad(BigDecimal.ZERO);
            calificacionEncuentro1.setComportamiento(BigDecimal.ZERO);
            calificacionEncuentro1.setHigiene(BigDecimal.ZERO);
            calificacionEncuentro1.setGeneral(BigDecimal.ZERO);
            calificacionEncuentro1.setEncuentro(encuentro);
            calificacionEncuentro1.setUsuario(user1);

            CalificacionEncuentro calificacionEncuentro2 = new CalificacionEncuentro();
            CalificacionEncuentroPK calificacionEncuentroPK2 = new CalificacionEncuentroPK(encuentro.getId(), user2.getId());
            calificacionEncuentro2.setCalificacionEncuentroPK(calificacionEncuentroPK2);
            calificacionEncuentro2.setAmabilidad(BigDecimal.ZERO);
            calificacionEncuentro2.setComportamiento(BigDecimal.ZERO);
            calificacionEncuentro2.setHigiene(BigDecimal.ZERO);
            calificacionEncuentro2.setGeneral(BigDecimal.ZERO);
            calificacionEncuentro2.setEncuentro(encuentro);
            calificacionEncuentro2.setUsuario(user2);

            calificacionEncuentroDAO.insert(calificacionEncuentro1);
            calificacionEncuentroDAO.insert(calificacionEncuentro2);

            return encuentro;
        } catch (Exception e) {
            throw new ValidationException(e, "Error en la creación del encuentro");
        }
    }

    public double calcularNivelDeCompatibilidad(String intereses1, String intereses2) {
        return StringSimilarity.similarity(intereses1, intereses2);
    }

    public void actualizarCalificacion(CalificacionEncuentro calificacionEncuentro, int usuario) {
        if (usuario == 1) {
            calificacionEncuentro.getEncuentro().setCalificacionPromedio1(new BigDecimal((calificacionEncuentro.getAmabilidadInt() + calificacionEncuentro.getComportamientoInt() + calificacionEncuentro.getGeneralInt() + calificacionEncuentro.getHigieneInt()) / 4));
        } else {
            calificacionEncuentro.getEncuentro().setCalificacionPromedio2(new BigDecimal((calificacionEncuentro.getAmabilidadInt() + calificacionEncuentro.getComportamientoInt() + calificacionEncuentro.getGeneralInt() + calificacionEncuentro.getHigieneInt()) / 4));
        }
        encuentroDAO.update(calificacionEncuentro.getEncuentro());

        calificacionEncuentroDAO.update(calificacionEncuentro);

    }

}

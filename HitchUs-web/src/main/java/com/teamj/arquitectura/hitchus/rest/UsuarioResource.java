/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.rest;

import com.teamj.arquitectura.hitchus.model.Encuentro;
import com.teamj.arquitectura.hitchus.model.EstadisticaUsuario;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.services.CertificadoServicio;
import com.teamj.arquitectura.hitchus.services.EncuentroServicio;
import com.teamj.arquitectura.hitchus.services.EstadisticaUsuarioServicio;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import com.teamj.arquitectura.hitchus.util.UsuarioList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dennys
 */
@Path("usuario")
@RequestScoped
public class UsuarioResource {

    @EJB
    UsuarioServicio usuarioServicio;
    @EJB
    CertificadoServicio certificadoServicio;
    @EJB
    EstadisticaUsuarioServicio estadisticaUsuarioServicio;
    @EJB
    EncuentroServicio encuentroServicio;

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.teamj.arquitectura.hitchus.rest.UsuarioResource
     *
     * @param id
     * @return an instance of com.teamj.arquitectura.hitchus.model.Usuario
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario find(@PathParam("id") Integer id) {
        //TODO return proper representation object
        return usuarioServicio.getCurrentUserById(id);
    }

    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/loggin")
    public Usuario getLogginCliente(@FormParam(value = "email") String email,
            @FormParam(value = "password") String password) {
        System.out.println(email);
        System.out.println(password);

        return usuarioServicio.ingresarMovil(email, password);
    }

    @GET
    @Produces("application/json")
    @Path("/listEncuentros")
    public List<Encuentro> listEncuentros(@WebParam(name = "id") String id) {

        //return null;
        return usuarioServicio.obtenerEncuentrosPorUsuario(usuarioServicio.getCurrentUserById(Integer.parseInt(id)));
    }

    //3 
    @GET
    @Produces("application/json")
    @Path("/getUsuario/{id}")

    public Usuario getUsuario(@PathParam(value = "id") String id) {
        // return null;
        return usuarioServicio.getCurrentUserById(Integer.parseInt(id));
    }

    //4
    @GET
    @Produces("application/json")

    @Path("/getTipoCertificado")
    public List<TipoCertificado> getTipoCertificado() {

        return certificadoServicio.obtenerTiposDeCertificado();
    }

    //5
    @GET
    @Produces("application/json")
    @Path("/getEstadisticaUsuario")
    public EstadisticaUsuario getEstadisticaUsuario(@WebParam(name = "id") String id) {

        return estadisticaUsuarioServicio.getEstadisticaUsuario(Integer.parseInt(id));
        //return null;
    }

    //6
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/bloquearUsuario")
    public void bloquearUsuario(@FormParam(value = "id_u1") String id_u1, @FormParam(value = "id_u2") String id_u2) {

        usuarioServicio.bloquearUsuario(Integer.parseInt(id_u1), Integer.parseInt(id_u2));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUsuariosCompatibles")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<Usuario> getUsuariosCompatibles(@FormParam(value = "id") String idString,
            @FormParam(value = "genero") String genero,
            @FormParam(value = "edadMinima") String edadMinimaString,
            @FormParam(value = "edadMaxima") String edadMaximaString,
            @FormParam(value = "distancia") String distanciaString,
            @FormParam(value = "nivelCompatibilidad") String nivelCompatibilidadString) {
        //     try {
        int id = Integer.parseInt(idString);
//            int edadMaxima =0;
//            int edadMinima = 0;
//            float distancia = 0;
//            int nivelCompatibilidad = 0;

        int edadMaxima = Integer.parseInt(edadMaximaString);
        int edadMinima = Integer.parseInt(edadMinimaString);
        float distancia = Float.parseFloat(distanciaString);
        int nivelCompatibilidad = Integer.parseInt(nivelCompatibilidadString);
        List<Usuario> usuarios = usuarioServicio.getCompatibleUsers(id, edadMinima, edadMaxima, distancia, nivelCompatibilidad, genero);
       // List<Usuario> usuarios = usuarioServicio.getAllUsersWithImages();
        //System.out.println("" + usuarios);
        
        System.out.println("" + id +" "+ edadMaximaString +" "+ edadMinimaString +" "+ distanciaString +" "+ nivelCompatibilidadString +" "+ genero);

//usuarios.toArray(new Usuario[usuarios.size()]);
        UsuarioList usuarioList = new UsuarioList();
        usuarioList.setContador(usuarios.size());
        usuarioList.setUsuarios(usuarios);

        return usuarios;

        //   } catch (Exception e) {
        //     System.out.println("" + e);
        //}
        //return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUsuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = usuarioServicio.getAllUsers();
        return usuarios;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUsuariosImagenes")
    public List<Usuario> getUsuariosImagenes() {
        return usuarioServicio.getAllUsersWithImages();
    }

    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/crearEncuentro")
    public Encuentro crearEncuentro(@FormParam(value = "id_u1") String id_u1, @FormParam(value = "id_u2") String id_u2) {

        return encuentroServicio.crearEncuentro(Integer.parseInt(id_u1), Integer.parseInt(id_u2));
    }

    /**
     * PUT method for updating or creating an instance of UsuarioResource
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Usuario content) {
    }
}

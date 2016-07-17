/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.ws;

import com.teamj.arquitectura.hitchus.model.Encuentro;
import com.teamj.arquitectura.hitchus.model.EstadisticaUsuario;
import com.teamj.arquitectura.hitchus.model.TipoCertificado;
import com.teamj.arquitectura.hitchus.model.Usuario;
import com.teamj.arquitectura.hitchus.services.CertificadoServicio;
import com.teamj.arquitectura.hitchus.services.EncuentroServicio;
import com.teamj.arquitectura.hitchus.services.EstadisticaUsuarioServicio;
import com.teamj.arquitectura.hitchus.services.UsuarioServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.FormParam;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author LENOVO
 */
@Path("webresources")
@RequestScoped
public class UsuarioRestServices {

    
     @Context
    private UriInfo context;
    
    @EJB
    UsuarioServicio usuarioServicio;
    
    @EJB
    EncuentroServicio encuentroServicio;
    
    @EJB
    CertificadoServicio certificadoServicio;
    
    @EJB
    EstadisticaUsuarioServicio estadisticaUsuarioServicio;


    /**
     * Creates a new instance of UsuarioRestServices
     */
    public UsuarioRestServices() {
    }

    /**
     * Retrieves representation of an instance of com.teamj.arquitectura.hitchus.ws.UsuarioRestServices
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UsuarioRestServices
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    
    }
    
        
    //1
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/loggin")
    public Usuario getLogginCliente(@FormParam(value= "email")String email, 
                                    @FormParam(value = "password") String password){
        
        return usuarioServicio.ingresar(email, password);
    }
    
    //2 FALTA USUARIO POR CONFLICTO
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/listEncuentros")
    public List<Encuentro> listEncuentros(@FormParam(value= "id")String id){    

        return null;
        //return usuarioServicio.obtenerEncuentrosPorUsuario(usuarioServicio.getCurrentUsuario(Integer.parseInt(id)));
    }
    
    //3 FALTA USUARIO POR CONFLICTO
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/getUsuario")
    public Usuario getUsuario(@FormParam(value= "id")String id){    
        return null;
     //   return usuarioServicio.getCurrentUsuario(Integer.parseInt(id));
    }
    
    
    //4
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/getTipoCertificado")
    public List<TipoCertificado> getTipoCertificado(){    

        return certificadoServicio.obtenerTiposDeCertificado();
    }
    
    //5 FALTA USUARIO POR CONFLICTO
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/getEstadisticaUsuario")
    public EstadisticaUsuario getEstadisticaUsuario(@FormParam(value= "id")String id){

        return null;
        //return estadisticaUsuarioServicio.obtenerEstadisticaUsuario(Integer.parseInt(id));
    }
    
    
}

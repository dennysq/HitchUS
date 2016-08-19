/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Jersey REST client generated for REST resource:SolicitudPremiumFacadeREST
 * [solicitudpremium]<br>
 * USAGE:
 * <pre>
 *        SuscripcionCliente client = new SuscripcionCliente();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author RICARDO
 */
public class SuscripcionCliente {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://10.9.5.48:29149/Subscripciones-web/webresources";

    public SuscripcionCliente() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("solicitudpremium");
    }

    public String crearSolicitud(String id, String email, String nombres, String apell, String genero, String certVIH,
            String certGON, String certSIF, String certHER, String certCLA, String certTRI) throws ClientErrorException {
        MultivaluedMap formData = new MultivaluedHashMap();
        formData.add("idUsu", id);
        formData.add("emailUsu", email);
        formData.add("nombresUsu", nombres);
        formData.add("apellUsu", apell);
        formData.add("geneUsu", genero);
        formData.add("certVIH", certVIH);
        formData.add("certGON", certGON);
        formData.add("certSIF", certSIF);
        formData.add("certHER", certHER);
        formData.add("certCLA", certCLA);
        formData.add("certTRI", certTRI);
        return webTarget.path("crearSolicitudPremium").request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.TEXT_PLAIN).post(Entity.form(formData), String.class);
    }

    public String consultarEstadoSolicitud(String idUsuario) throws ClientErrorException {
        MultivaluedMap formData = new MultivaluedHashMap();
        formData.add("idUsu", idUsuario);
        return webTarget.path("estadoSolicitudPremium").request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.TEXT_PLAIN).post(Entity.form(formData), String.class);
    }

    public void close() {
        client.close();
    }

}

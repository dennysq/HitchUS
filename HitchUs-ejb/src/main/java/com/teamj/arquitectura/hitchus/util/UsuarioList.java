/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.util;

import com.teamj.arquitectura.hitchus.model.Usuario;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dennys
 */

public class UsuarioList {

    private List<Usuario> usuarios;
    private int contador;

    public UsuarioList() {
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}

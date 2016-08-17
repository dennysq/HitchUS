/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.model;

import com.teamj.arquitectura.hitchus.nosql.dao.UsuarioDAO;
import com.teamj.arquitectura.hitchus.nosql.persistence.PersistenceManager;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Dennys
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @SequenceGenerator(name = "USUARIO_ID", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USUARIO_ID")
    @Column(name = "ID_USUARIO")
    private Integer id;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Transient
    private Integer anioNacimiento;

    @Transient
    private Integer mesNacimiento;

    @Transient
    private BigDecimal estatura;

    @Transient
    private Boolean trabajo;

    @Transient
    private String premium;

    @Transient
    private String numeroTelefonico;

    @Transient
    private String estado;

    @Transient
    private BigDecimal calificacion;

    @Transient
    private String genero;

    @Transient
    private String intereses;

    @Transient
    private String contextura;

    @Transient
    private String nivelEducacion;

    @Transient
    private String idiomas;

    @Transient
    private BigDecimal peso;

    @Transient
    private Boolean enfermedadesPublica;

    @Column(name = "CREADO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creado;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS_ORIGEN")
    private PaisOrigen paisOrigen;

    @ManyToOne
    @JoinColumn(name = "ID_CIUDAD_RESIDENCIA")
    private CiudadResidencia ciudadResidencia;

    @OneToMany(mappedBy = "usuario1", targetEntity = Encuentro.class,
            fetch = FetchType.LAZY)
    List<Encuentro> encuentros;
    @OneToMany(mappedBy = "usuario", targetEntity = Imagen.class,
            fetch = FetchType.LAZY)
    List<Imagen> imagenes;

    public Usuario() {
    }

    @PostLoad
    public void load() {
        System.out.println("cargando info desde mongo");
        UsuarioDAO usuarioDAO = new UsuarioDAO(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class, PersistenceManager.instance().datastore());
        com.teamj.arquitectura.hitchus.nosql.model.Usuario temp = usuarioDAO.findOne("email", email);
        if (temp != null) {
            this.anioNacimiento = temp.getAnioNacimiento();
            this.calificacion = new BigDecimal(temp.getCalificacion());
            this.contextura = temp.getContextura();
            this.enfermedadesPublica = temp.getEnfermedadesPublica();
            this.estado = temp.getEstado();
            this.genero = temp.getGenero();
            this.nivelEducacion = temp.getNivelEducacion();
            this.idiomas = temp.getIdiomas();
            this.intereses = temp.getIntereses();
            this.numeroTelefonico = temp.getNumeroTelefonico();
            this.mesNacimiento = temp.getMesNacimiento();
            this.premium = temp.getPremium();
            this.trabajo = temp.getTrabajo();
            this.peso = new BigDecimal(temp.getPeso());
            this.estatura = new BigDecimal(temp.getEstatura());
        }

    }

    @PostPersist
    public void saveNoSqlUser() {
        UsuarioDAO usuarioDAO = new UsuarioDAO(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class, PersistenceManager.instance().datastore());
        com.teamj.arquitectura.hitchus.nosql.model.Usuario user = new com.teamj.arquitectura.hitchus.nosql.model.Usuario();
        user.setAnioNacimiento(anioNacimiento);
        if (calificacion != null) {
            user.setCalificacion(calificacion.floatValue());
        } else {
            user.setCalificacion(0.0f);
        }
        user.setContextura(contextura);
        user.setEmail(email);
        user.setEnfermedadesPublica(enfermedadesPublica);
        user.setEstado(estado);
        if (estatura != null) {
            user.setEstatura(estatura.floatValue());
        } else {
            user.setEstatura(0.0f);

        }
        user.setGenero(genero);
        user.setIdUsuario(id);
        user.setIdiomas(idiomas);
        user.setIntereses(intereses);
        user.setMesNacimiento(mesNacimiento);
        user.setNickname(nickname);
        user.setNivelEducacion(nivelEducacion);
        user.setNumeroTelefonico(numeroTelefonico);
        if (paisOrigen != null) {
            user.setPaisOrigen(paisOrigen.getNombre());
        }
        if (ciudadResidencia != null) {
            user.setCiudadResidencia(ciudadResidencia.getNombre());
        }
        user.setPassword(password);
        if (peso != null) {
            user.setPeso(peso.floatValue());
        } else {
            user.setPeso(0.0f);

        }
        user.setPremium(premium);
        user.setTrabajo(trabajo);

        //com.teamj.arquitectura.hitchus.nosql.model.Usuario temp = usuarioDAO.findOne("email", user.getEmail());
        //if (temp == null) {
        usuarioDAO.save(user);

        // } else {
        //}
    }

//    @PostUpdate
//    public void updateNoSqlUser() {
//        System.out.println("actualizndo en mongo");
//        UsuarioDAO usuarioDAO = new UsuarioDAO(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class, PersistenceManager.instance().datastore());
//        // com.teamj.arquitectura.hitchus.nosql.model.Usuario user = new com.teamj.arquitectura.hitchus.nosql.model.Usuario();
//        com.teamj.arquitectura.hitchus.nosql.model.Usuario user = usuarioDAO.findOne("idUsuario", id);
//        if (user != null) {
//            Query<com.teamj.arquitectura.hitchus.nosql.model.Usuario> query = PersistenceManager.instance().datastore().createQuery(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class).field("idUsuario").equal(id);
//            UpdateOperations<com.teamj.arquitectura.hitchus.nosql.model.Usuario> ops;
//            if (ciudadResidencia != null && paisOrigen != null) {
//                ops = PersistenceManager.instance().datastore()
//                        .createUpdateOperations(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class)
//                        .set("anioNacimiento", anioNacimiento)
//                        .set("calificacion", calificacion==null?0.0f:calificacion.floatValue())
//                        .set("contextura", contextura==null?"":contextura)
//                        .set("email", email)
//                        .set("enfermedadesPublica", enfermedadesPublica)
//                        .set("estado", estado==null?"":estado)
//                        .set("estatura", estatura==null?0.0f:estatura.floatValue())
//                        .set("genero", genero==null?"":genero)
//                        .set("idiomas", idiomas==null?"":idiomas)
//                        .set("intereses", intereses==null?"":intereses)
//                        .set("mesNacimiento", mesNacimiento)
//                        .set("nickname", nickname==null?"":nickname)
//                        .set("nivelEducacion", nivelEducacion==null?"":nivelEducacion)
//                        .set("numeroTelefonico", numeroTelefonico==null?"":numeroTelefonico)
//                        .set("password", password)
//                        .set("peso", peso==null?0.0f:peso.floatValue())
//                        .set("premium", premium==null?"":premium)
//                        .set("ciudadResidencia", ciudadResidencia.getNombre())
//                        .set("paisOrigen", paisOrigen.getNombre())
//                        .set("trabajo", trabajo==null?"":trabajo);
//
//            } else {
//                ops = PersistenceManager.instance().datastore()
//                        .createUpdateOperations(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class)
//                        .set("anioNacimiento", anioNacimiento)
//                        .set("calificacion", calificacion.floatValue())
//                        .set("contextura", contextura)
//                        .set("email", email)
//                        .set("enfermedadesPublica", enfermedadesPublica)
//                        .set("estado", estado)
//                        .set("estatura", estatura.floatValue())
//                        .set("genero", genero)
//                        .set("idiomas", idiomas)
//                        .set("intereses", intereses)
//                        .set("mesNacimiento", mesNacimiento)
//                        .set("nickname", nickname)
//                        .set("nivelEducacion", nivelEducacion)
//                        .set("numeroTelefonico", numeroTelefonico)
//                        .set("password", password)
//                        .set("peso", peso.floatValue())
//                        .set("premium", premium)
//                        .set("trabajo", trabajo);
//            }
//            //com.teamj.arquitectura.hitchus.nosql.model.Usuario temp = usuarioDAO.findOne("email", user.getEmail());
//            //if (temp == null) {
//            usuarioDAO.update(query, ops);
//
//        }

        // } else {
        //}
    //}

    @PostRemove
    public void delete() {
        System.out.println("removiendo actualizndo en mongo");
        UsuarioDAO usuarioDAO = new UsuarioDAO(com.teamj.arquitectura.hitchus.nosql.model.Usuario.class, PersistenceManager.instance().datastore());

        com.teamj.arquitectura.hitchus.nosql.model.Usuario user = usuarioDAO.findOne("idUsuario", id);
        if (user != null) {
            usuarioDAO.delete(user);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(Integer mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public BigDecimal getEstatura() {
        return estatura;
    }

    public void setEstatura(BigDecimal estatura) {
        this.estatura = estatura;
    }

    public Boolean getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Boolean trabajo) {
        this.trabajo = trabajo;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getContextura() {
        return contextura;
    }

    public void setContextura(String contextura) {
        this.contextura = contextura;
    }

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Boolean getEnfermedadesPublica() {
        return enfermedadesPublica;
    }

    public void setEnfermedadesPublica(Boolean enfermedadesPublica) {
        this.enfermedadesPublica = enfermedadesPublica;
    }

    public PaisOrigen getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(PaisOrigen paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public CiudadResidencia getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(CiudadResidencia ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public void setEncuentros(List<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Encuentro> getEncuentros() {
        return encuentros;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email + ", anioNacimiento=" + anioNacimiento + ", mesNacimiento=" + mesNacimiento + ", estatura=" + estatura + ", trabajo=" + trabajo + ", premium=" + premium + ", numeroTelefonico=" + numeroTelefonico + ", estado=" + estado + ", calificacion=" + calificacion + ", genero=" + genero + ", intereses=" + intereses + ", contextura=" + contextura + ", nivelEducacion=" + nivelEducacion + ", idiomas=" + idiomas + ", peso=" + peso + ", creado=" + creado + ", enfermedadesPublica=" + enfermedadesPublica + '}';
    }
}

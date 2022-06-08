package com.examen.demo.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario")
    private int id;

    @NotNull
    private String usuario;

    @NotNull
    private String contrasenia;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "personal_id", referencedColumnName = "idPersonal", nullable = true)
    private Personal personal;

    @OneToMany(mappedBy = "usuario")
    private Set<Nota> notas;

    @OneToMany(mappedBy = "usuario")
    private Set<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private Set<Respuesta> respuestas;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idRol")
            )
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(int id, @NotNull String usuario, @NotNull String contrasenia, Personal personal, Set<Nota> notas,
            Set<Comentario> comentarios, Set<Respuesta> respuestas) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.personal = personal;
        this.notas = notas;
        this.comentarios = comentarios;
        this.respuestas = respuestas;
    }

    public Usuario(@NotNull String usuario, @NotNull String contrasenia, Personal personal, Set<Nota> notas,
            Set<Comentario> comentarios, Set<Respuesta> respuestas) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.personal = personal;
        this.notas = notas;
        this.comentarios = comentarios;
        this.respuestas = respuestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Set<Nota> getNotas() {
        return notas;
    }

    public void setNotas(Set<Nota> notas) {
        this.notas = notas;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Set<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Set<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

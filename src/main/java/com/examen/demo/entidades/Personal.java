package com.examen.demo.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPersonal")
    private int id;

    @NotNull
    private String apePaterno;

    private String apeMaterno;

    @NotNull
    private String nombre;

    @NotNull
    private String direccion;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;

    @OneToOne(mappedBy = "personal")
    private Usuario usuario;

    public Personal() {
    }

    public Personal(int id, @NotNull String apePaterno, String apeMaterno, @NotNull String nombre,
            @NotNull String direccion, @NotNull Date fechaIngreso, Usuario usuario) {
        this.id = id;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
    }

    public Personal(@NotNull String apePaterno, String apeMaterno, @NotNull String nombre,
            @NotNull String direccion, @NotNull Date fechaIngreso, Usuario usuario) {
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
    }

    public Personal(@NotNull String apePaterno, String apeMaterno, @NotNull String nombre,
            @NotNull String direccion, @NotNull Date fechaIngreso) {
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

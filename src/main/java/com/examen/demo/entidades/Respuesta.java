package com.examen.demo.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "Respuestas")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idRespuesta")
    private int id;

    @NotNull
    private String repuesta;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "comentario_id", nullable = false)
    private Comentario comentario;

    public Respuesta() {
    }

    public Respuesta(int id, @NotNull String repuesta, @NotNull Date fecha, Usuario usuario, Comentario comentario) {
        this.id = id;
        this.repuesta = repuesta;
        this.fecha = fecha;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public Respuesta(@NotNull String repuesta, @NotNull Date fecha, Usuario usuario, Comentario comentario) {
        this.repuesta = repuesta;
        this.fecha = fecha;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepuesta() {
        return repuesta;
    }

    public void setRepuesta(String repuesta) {
        this.repuesta = repuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

}

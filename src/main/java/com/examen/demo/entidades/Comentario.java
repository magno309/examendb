package com.examen.demo.entidades;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.OneToMany;

@Entity
@Table(name = "Comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idComentario")
    private int id;

    @NotNull
    private String comentario;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "nota_id", nullable = false)
    private Nota nota;

    @OneToMany(mappedBy = "comentario")
    private Set<Respuesta> respuestas;

    public Comentario() {
    }

    public Comentario(int id, @NotNull String comentario, @NotNull Date fecha, Usuario usuario, Nota nota,
            Set<Respuesta> respuestas) {
        this.id = id;
        this.comentario = comentario;
        this.fecha = fecha;
        this.usuario = usuario;
        this.nota = nota;
        this.respuestas = respuestas;
    }

    public Comentario(@NotNull String comentario, @NotNull Date fecha, Usuario usuario, Nota nota,
            Set<Respuesta> respuestas) {
        this.comentario = comentario;
        this.fecha = fecha;
        this.usuario = usuario;
        this.nota = nota;
        this.respuestas = respuestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Set<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Set<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}

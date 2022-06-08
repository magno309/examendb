package com.examen.demo.entidades;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idNota")
    private int id;

    @NotNull
    private String nota;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "nota")
    private Set<Nota> comentarios;

    public Nota() {
    }

    public Nota(int id, @NotNull String nota, @NotNull Date fecha, Usuario usuario, Set<Nota> comentarios) {
        this.id = id;
        this.nota = nota;
        this.fecha = fecha;
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    public Nota(@NotNull String nota, @NotNull Date fecha, Usuario usuario, Set<Nota> comentarios) {
        this.nota = nota;
        this.fecha = fecha;
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Nota> getComentarios() {
        return comentarios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setComentarios(Set<Nota> comentarios) {
        this.comentarios = comentarios;
    }
}

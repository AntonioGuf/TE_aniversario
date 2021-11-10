package com.emergentes.modelo;

public class Evento {

    private int id;
    private String titulo;
    private String expositor;
    private String fecha;
    private String hora;
    private String cupo;

    public Evento() {
        this.id = 0;
        this.titulo = "";
        this.expositor = "";
        this.fecha = "";
        this.hora = "";
        this.cupo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getExpositor() {
        return expositor;
    }

    public void setExpositor(String expositor) {
        this.expositor = expositor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCupo() {
        return cupo;
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", titulo" + titulo + ", expositor" + expositor + ", fecha" + fecha + ", hora" + hora + ", cupo" + cupo + '}';
    }
}

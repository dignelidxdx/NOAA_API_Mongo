package ar.com.noaa.mongo.api.entities;

import java.util.Date;

public class Muestra {
    
    //private ObjectId _id;

    private Date horarioMuestra;
    private String matriculaEmbarcacion;
    private Double latitud;
    private Double longitud;
    private Double alturaNivelDelMar;

    public Date getHorarioMuestra() {
        return horarioMuestra;
    }

    public void setHorarioMuestra(Date horarioMuestra) {
        this.horarioMuestra = horarioMuestra;
    }

    public String getMatriculaEmbarcacion() {
        return matriculaEmbarcacion;
    }

    public void setMatriculaEmbarcacion(String matriculaEmbarcacion) {
        this.matriculaEmbarcacion = matriculaEmbarcacion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getAlturaNivelDelMar() {
        return alturaNivelDelMar;
    }

    public void setAlturaNivelDelMar(Double alturaNivelDelMar) {
        this.alturaNivelDelMar = alturaNivelDelMar;
    }
}

package com.mifincaapp.mifincaapp.db;

/**
 * Created by USUARIO on 28/11/2016.
 */

public class Reg_reidentificacion {
    String fecha;
    String areteanterior;
    String aretenuevo;
    String motivocambio;


    public Reg_reidentificacion(){

    }

    public Reg_reidentificacion(String areteanterior, String aretenuevo, String fecha, String motivocambio) {
        this.areteanterior = areteanterior;
        this.aretenuevo = aretenuevo;
        this.fecha = fecha;
        this.motivocambio = motivocambio;
    }

    public String getAreteanterior() {
        return areteanterior;
    }

    public void setAreteanterior(String areteanterior) {
        this.areteanterior = areteanterior;
    }

    public String getAretenuevo() {
        return aretenuevo;
    }

    public void setAretenuevo(String aretenuevo) {
        this.aretenuevo = aretenuevo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivocambio() {
        return motivocambio;
    }

    public void setMotivocambio(String motivocambio) {
        this.motivocambio = motivocambio;
    }

}

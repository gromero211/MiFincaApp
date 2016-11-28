package com.mifincaapp.mifincaapp.db;

/**
 * Created by GARF on 27/11/2016.
 */

public class Reg_Control {
 String arete, diagnostico, metodo, semental, parto, desarrollo, crias, comentarios;

    public Reg_Control() {

    }

    public Reg_Control(String arete, String comentarios, String crias, String desarrollo, String diagnostico, String metodo, String parto, String semental) {
        this.arete = arete;
        this.comentarios = comentarios;
        this.crias = crias;
        this.desarrollo = desarrollo;
        this.diagnostico = diagnostico;
        this.metodo = metodo;
        this.parto = parto;
        this.semental = semental;
    }

    public String getArete() {
        return arete;
    }

    public void setArete(String arete) {
        this.arete = arete;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getCrias() {
        return crias;
    }

    public void setCrias(String crias) {
        this.crias = crias;
    }

    public String getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(String desarrollo) {
        this.desarrollo = desarrollo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getParto() {
        return parto;
    }

    public void setParto(String parto) {
        this.parto = parto;
    }

    public String getSemental() {
        return semental;
    }

    public void setSemental(String semental) {
        this.semental = semental;
    }
}

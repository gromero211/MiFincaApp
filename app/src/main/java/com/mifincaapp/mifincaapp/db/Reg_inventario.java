package com.mifincaapp.mifincaapp.db;

/**
 * Created by GARF on 23/11/2016.
 */

public class Reg_inventario {
    String fecha;
    String arete;
    String edad;
    String categoria;
    String raza;

    public Reg_inventario(){

    }

    public Reg_inventario(String arete, String categoria, String edad, String fecha, String raza) {
        this.arete = arete;
        this.categoria = categoria;
        this.edad = edad;
        this.fecha = fecha;
        this.raza = raza;
    }

    public String getArete() {
        return arete;
    }

    public void setArete(String arete) {
        this.arete = arete;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}

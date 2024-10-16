package com.example.practicaconversor1.modelo;

public class Moneda {
    String nombre;
    Integer codigo;
    float multiplicador;

    public Moneda(String nombre, float multiplicador) {
        this.nombre = nombre;
        this.multiplicador = multiplicador;
    }

    public Moneda(String nombre, float multiplicador, Integer codigo) {
        this.nombre = nombre;
        this.multiplicador = multiplicador;
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMultiplicador() {
        return this.multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    public String toString() {
        return "MonedaVO{nombre=" + this.nombre + ", multiplicador=" + this.multiplicador + '}';
    }
}
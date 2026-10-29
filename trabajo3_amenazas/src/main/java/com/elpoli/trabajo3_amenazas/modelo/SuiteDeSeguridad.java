package com.elpoli.trabajo3_amenazas.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class SuiteDeSeguridad {
    private String nombreSuite;
    private EnumAmenaza tipoBase;
    private Categoria categoriaBase;
    private Deque<Amenaza> amenazas;

    // Constructor vacío
    public SuiteDeSeguridad() {
        this.amenazas = new ArrayDeque<>();
    }

    // Constructor con atributos (incluyendo los dos enums)
    public SuiteDeSeguridad(String nombreSuite, EnumAmenaza tipoBase, Categoria categoriaBase) {
        this.nombreSuite = nombreSuite;
        this.tipoBase = tipoBase;
        this.categoriaBase = categoriaBase;
        this.amenazas = new ArrayDeque<>();
    }

    // Método para agregar objetos al Deque
    public void agregarAmenaza(Amenaza amenaza) {
        this.amenazas.add(amenaza);
    }

    // Getters y Setters
    public String getNombreSuite() { return nombreSuite; }
    public void setNombreSuite(String nombreSuite) { this.nombreSuite = nombreSuite; }
    public EnumAmenaza getTipoBase() { return tipoBase; }
    public void setTipoBase(EnumAmenaza tipoBase) { this.tipoBase = tipoBase; }
    public Categoria getCategoriaBase() { return categoriaBase; }
    public void setCategoriaBase(Categoria categoriaBase) { this.categoriaBase = categoriaBase; }
    public Deque<Amenaza> getAmenazas() { return amenazas; }
    public void setAmenazas(Deque<Amenaza> amenazas) { this.amenazas = amenazas; }
}
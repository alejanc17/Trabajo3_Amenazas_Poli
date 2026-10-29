package com.elpoli.trabajo3_amenazas.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Amenaza {
    private String nombre;
    private EnumAmenaza tipo;
    private Categoria categoria;
    private Stack<Integer> conteo;

    // Constructor vacío
    public Amenaza() {
        this.conteo = new Stack<>();
    }

    // Constructor con los atributos (incluyendo los dos enums)
    public Amenaza(String nombre, EnumAmenaza tipo, Categoria categoria) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
        this.conteo = new Stack<>();
    }

    // Método para agregar datos al Stack
    public void agregarAlConteo(Integer valor) {
        this.conteo.push(valor);
    }

    // PUNTO 5: Método que recibe la interface Function
    public Integer verTotales(Function<Amenaza, Integer> funcionSuma) {
        return funcionSuma.apply(this);
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public EnumAmenaza getTipo() { return tipo; }
    public void setTipo(EnumAmenaza tipo) { this.tipo = tipo; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public Stack<Integer> getConteo() { return conteo; }
    public void setConteo(Stack<Integer> conteo) { this.conteo = conteo; }
}
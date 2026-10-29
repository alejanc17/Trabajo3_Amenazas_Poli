package com.elpoli.trabajo3_amenazas.repositories;

import com.elpoli.trabajo3_amenazas.modelo.Amenaza;
import com.elpoli.trabajo3_amenazas.modelo.Categoria;
import com.elpoli.trabajo3_amenazas.modelo.EnumAmenaza;
import com.elpoli.trabajo3_amenazas.modelo.SuiteDeSeguridad;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public class DatosRepository {

    private Stack<Amenaza> stackAmenazas;
    private SuiteDeSeguridad suite;

    public DatosRepository() {
        stackAmenazas = new Stack<>();

        // 1. Crear los 5 objetos con los MISMOS enums (Exigido en Punto 1)
        Amenaza a1 = new Amenaza("Virus Alpha", EnumAmenaza.MALWARE, Categoria.RED);
        a1.agregarAlConteo(10);
        a1.agregarAlConteo(20);

        Amenaza a2 = new Amenaza("Troyano Beta", EnumAmenaza.MALWARE, Categoria.RED);
        a2.agregarAlConteo(5);

        Amenaza a3 = new Amenaza("Gusano Gamma", EnumAmenaza.MALWARE, Categoria.RED);
        a3.agregarAlConteo(15);
        a3.agregarAlConteo(30);

        Amenaza a4 = new Amenaza("Spyware Delta", EnumAmenaza.MALWARE, Categoria.RED);
        a4.agregarAlConteo(100);

        Amenaza a5 = new Amenaza("Ransomware Epsilon", EnumAmenaza.MALWARE, Categoria.RED);
        a5.agregarAlConteo(2);
        a5.agregarAlConteo(4);
        a5.agregarAlConteo(6);

        // 2. Guardarlos en un Stack (Exigido en Punto 1)
        stackAmenazas.push(a1);
        stackAmenazas.push(a2);
        stackAmenazas.push(a3);
        stackAmenazas.push(a4);
        stackAmenazas.push(a5);

        // 3. Crear el objeto contenedor con los MISMOS enums (Exigido en Punto 1)
        suite = new SuiteDeSeguridad("Suite Protectora Poli", EnumAmenaza.MALWARE, Categoria.RED);

        // 4. Agregar los 5 objetos al Deque usando el método (Exigido en Punto 1)
        suite.agregarAmenaza(a1);
        suite.agregarAmenaza(a2);
        suite.agregarAmenaza(a3);
        suite.agregarAmenaza(a4);
        suite.agregarAmenaza(a5);
    }

    public Stack<Amenaza> getStackAmenazas() {
        return stackAmenazas;
    }

    public SuiteDeSeguridad getSuite() {
        return suite;
    }
}
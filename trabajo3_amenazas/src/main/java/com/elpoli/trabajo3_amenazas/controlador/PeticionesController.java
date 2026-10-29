package com.elpoli.trabajo3_amenazas.controlador;

import com.elpoli.trabajo3_amenazas.modelo.Amenaza;
import com.elpoli.trabajo3_amenazas.modelo.EnumAmenaza;
import com.elpoli.trabajo3_amenazas.repositories.DatosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class PeticionesController {

    private final DatosRepository repository;

    public PeticionesController(DatosRepository repository) {
        this.repository = repository;
    }

    // Menú principal
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // PUNTO 2: Uso de ListIterator e Iterator
    @GetMapping("/punto2")
    public String punto2(Model model) {
        List<String> resultadosStack = new ArrayList<>();
        List<String> resultadosDeque = new ArrayList<>();

        // Iterando el Stack con ListIterator
        ListIterator<Amenaza> listIterator = repository.getStackAmenazas().listIterator();
        while (listIterator.hasNext()) {
            Amenaza a = listIterator.next();
            resultadosStack.add("Nombre: " + a.getNombre() + " | Tipo: " + a.getTipo() + " | Categoría: " + a.getCategoria() + " | Conteo: " + a.getConteo());
        }

        // Iterando el Deque con Iterator usando el método iterator()
        Iterator<Amenaza> iteratorDeque = repository.getSuite().getAmenazas().iterator();
        while (iteratorDeque.hasNext()) {
            Amenaza a = iteratorDeque.next();
            resultadosDeque.add("Nombre: " + a.getNombre() + " | Tipo: " + a.getTipo() + " | Categoría: " + a.getCategoria() + " | Conteo: " + a.getConteo());
        }

        model.addAttribute("resultadosStack", resultadosStack);
        model.addAttribute("resultadosDeque", resultadosDeque);
        return "punto2";
    }

    // PUNTO 3: Programación Funcional filtrando por un enum específico
    @GetMapping("/punto3")
    public String punto3(Model model) {
        // Filtramos funcionalmente el Deque buscando solo los que sean MALWARE
        List<Amenaza> amenazasFiltradas = repository.getSuite().getAmenazas().stream()
                .filter(a -> a.getTipo() == EnumAmenaza.MALWARE)
                .collect(Collectors.toList());

        model.addAttribute("amenazas", amenazasFiltradas);
        return "punto3";
    }

    // PUNTOS 4 y 5: Interface Function y llamado al método verTotales
    @GetMapping("/punto4y5")
    public String punto4y5(Model model) {

        // PUNTO 4: Función que recibe un objeto y retorna la suma de su Stack de enteros
        Function<Amenaza, Integer> calcularSumaConteo = (amenaza) -> {
            return amenaza.getConteo().stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        };

        // PUNTO 5: Hacemos que un objeto ya creado llame al método pasándole la función
        // Tomamos el primer objeto guardado en el Stack para la prueba
        Amenaza objetoPrueba = repository.getStackAmenazas().get(0);
        Integer totalCalculado = objetoPrueba.verTotales(calcularSumaConteo);

        model.addAttribute("objeto", objetoPrueba);
        model.addAttribute("total", totalCalculado);
        return "punto4y5";
    }
}
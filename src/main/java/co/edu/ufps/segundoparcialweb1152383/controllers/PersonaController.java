package co.edu.ufps.segundoparcialweb1152383.controllers;

import co.edu.ufps.segundoparcialweb1152383.models.Persona;
import co.edu.ufps.segundoparcialweb1152383.services.PersonaServices;
import co.edu.ufps.segundoparcialweb1152383.utils.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@Tag(name = "Personas", description = "API de las personas")
public class PersonaController {

    @Autowired
    private PersonaServices personaServices;

    // GET /api/personas
    @GetMapping
    public ApiResponse<List<Persona>> listarPersonas() {
        List<Persona> personas = personaServices.listar();
        return new ApiResponse<>("success", "Listado de personas", personas);
    }

    // GET /api/personas/{id}
    @GetMapping("/{id}")
    public ApiResponse<Persona> obtenerPersonaPorId(@PathVariable Integer id) {
        Persona p = personaServices.obtenerPorId(id);
        if (p != null) {
            return new ApiResponse<>("success", "Persona encontrada", p);
        }
        return new ApiResponse<>("error", "Persona no encontrada", null);
    }

    // POST /api/personas
    @PostMapping
    public ApiResponse<Persona> crearPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personaServices.crear(persona);
        return new ApiResponse<>("created", "Persona creada", nuevaPersona);
    }

}
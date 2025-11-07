package co.edu.ufps.segundoparcialweb1152383.services;

import co.edu.ufps.segundoparcialweb1152383.models.Persona;
import co.edu.ufps.segundoparcialweb1152383.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaServices {

    @Autowired
    private PersonaRepository personaRepository;

    // Listar todas las personas
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    public Persona obtenerPorId(Integer id) {
        return personaRepository.findById(id).orElse(null);
    }

    // Crear una nueva persona
    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }

}


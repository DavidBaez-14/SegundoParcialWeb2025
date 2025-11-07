package co.edu.ufps.segundoparcialweb1152383.services;

import co.edu.ufps.segundoparcialweb1152383.models.*;
import co.edu.ufps.segundoparcialweb1152383.repositories.EstadoRepository;
import co.edu.ufps.segundoparcialweb1152383.repositories.PersonaRepository;
import co.edu.ufps.segundoparcialweb1152383.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SolicitudServices {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<SolicitudDTO> listar() {
        List<Solicitud> solicitudes = solicitudRepository.findAll();
        List<SolicitudDTO> resultado = new ArrayList<>();
        for (Solicitud s : solicitudes) {
            String nombreSolicitante = s.getSolicitante() != null ? s.getSolicitante().getNombre() : null;
            String nombreCodeudor = s.getCodeudor() != null ? s.getCodeudor().getNombre() : null;
            String estado = s.getEstado() != null ? s.getEstado().getDescripcion() : null;
            resultado.add(new SolicitudDTO(
                    s.getId(),
                    s.getFecha(),
                    nombreSolicitante,
                    nombreCodeudor,
                    estado,
                    s.getCodigoRadicado()
            ));
        }
        return resultado;
    }

    public Solicitud registrarSolicitud(Integer idSolicitante, Integer idCodeudor) {
        if (idSolicitante.equals(idCodeudor)) {
            throw new RuntimeException("El solicitante y el codeudor no pueden iguales");
        }

        Persona solicitante = personaRepository.findById(idSolicitante).orElse(null);
        Persona codeudor = personaRepository.findById(idCodeudor).orElse(null);

        if (solicitante == null) {
            throw new RuntimeException("Solicitante no encontrado");
        }
        if (codeudor == null) {
            throw new RuntimeException("Codeudor no encontrado");
        }

        Estado estado = estadoRepository.findById(1).orElse(null);
        if (estado == null) {
            throw new RuntimeException("Estado no encontrado");
        }

        Solicitud solicitud = new Solicitud();
        solicitud.setFecha(LocalDate.now());
        solicitud.setSolicitante(solicitante);
        solicitud.setCodeudor(codeudor);
        solicitud.setValor(BigDecimal.ZERO);
        solicitud.setEstado(estado);
        solicitud.setCodigoRadicado("dmee32");

        return solicitudRepository.save(solicitud);
    }
}
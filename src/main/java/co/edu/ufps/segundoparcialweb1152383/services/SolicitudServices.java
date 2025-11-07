package co.edu.ufps.segundoparcialweb1152383.services;

import co.edu.ufps.segundoparcialweb1152383.models.Solicitud;
import co.edu.ufps.segundoparcialweb1152383.models.SolicitudDTO;
import co.edu.ufps.segundoparcialweb1152383.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitudServices {

    @Autowired
    private SolicitudRepository solicitudRepository;

    // Listar solicitudes mapeadas a SolicitudDTO (solo nombres de personas, no objetos completos)
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
}
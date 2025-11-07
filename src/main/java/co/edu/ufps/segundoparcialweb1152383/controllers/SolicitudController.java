package co.edu.ufps.segundoparcialweb1152383.controllers;

import co.edu.ufps.segundoparcialweb1152383.models.Solicitud;
import co.edu.ufps.segundoparcialweb1152383.models.SolicitudDTO;
import co.edu.ufps.segundoparcialweb1152383.services.SolicitudServices;
import co.edu.ufps.segundoparcialweb1152383.utils.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@Tag(name = "Solicitudes", description = "API de las solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudServices solicitudServices;

    @GetMapping
    public ApiResponse<List<SolicitudDTO>> listarSolicitudes() {
        List<SolicitudDTO> lista = solicitudServices.listar();
        return new ApiResponse<>("success", "Listado de solicitudes", lista);
    }

    @PostMapping("/{idSolicitante}/{idCodeudor}")
    public ApiResponse<Solicitud> registrarSolicitud(
            @PathVariable Integer idSolicitante,
            @PathVariable Integer idCodeudor) {
        try {
            Solicitud solicitud = solicitudServices.registrarSolicitud(idSolicitante, idCodeudor);
            return new ApiResponse<>("created", "Solicitud registrada exitosamente", solicitud);
        } catch (RuntimeException e) {
            return new ApiResponse<>("error", e.getMessage(), null);
        }
    }
}
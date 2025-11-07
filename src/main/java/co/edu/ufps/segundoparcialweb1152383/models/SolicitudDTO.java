package co.edu.ufps.segundoparcialweb1152383.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {
    private Integer id;
    private LocalDate fecha;
    private String nombreSolicitante;
    private String nombreCodeudor;
    private String estado;
    private String codigoRadicado;
}
package co.edu.ufps.segundoparcialweb1152383.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "solicitud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Persona solicitante;

    @ManyToOne
    @JoinColumn(name = "codeudor_id")
    private Persona codeudor;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @Column(name = "codigo_radicado")
    private String codigoRadicado;
}

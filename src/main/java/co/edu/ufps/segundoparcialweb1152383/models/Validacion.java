package co.edu.ufps.segundoparcialweb1152383.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "validacion")
@Data
@IdClass(Validacion.ValidacionId.class)
public class Validacion {

    @Id
    private Integer id;

    @Id
    @Column(name = "token")
    private String token;

    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "documento", nullable = false)
    private String documento;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "estado")
    private String estado; // Verificar pendiente o Validada


    @Data
    public static class ValidacionId implements Serializable {
        private Integer id;
        private String token;
        private String codigo;
    }
}

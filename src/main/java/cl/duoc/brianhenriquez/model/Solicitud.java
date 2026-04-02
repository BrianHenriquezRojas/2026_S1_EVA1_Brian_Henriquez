package cl.duoc.brianhenriquez.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Solicitud {

    private Long id;

    @NotBlank(message = "El nombre del paciente es obligatorio")
    private String nombrePaciente;

    @NotBlank(message = "El RUT es obligatorio")
    private String rutPaciente;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotNull(message = "La prioridad es obligatoria")
    private Prioridad prioridad;

    private EstadoSolicitud estado;
    private LocalDateTime fechaRegistro;

}

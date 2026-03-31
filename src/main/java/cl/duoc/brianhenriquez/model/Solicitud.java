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

    @NotBlank(message = "El nombre del paciente es obligatorio")
    private String nombrePaciente;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotNull(message = "El estado es obligatorio")
    private EstadoSolicitud estado;

    private LocalDateTime fechaRegistro;

    @NotNull(message = "La prioridad es obligatoria")
    private Prioridad prioridad;
}

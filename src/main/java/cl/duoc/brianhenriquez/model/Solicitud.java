package cl.duoc.brianhenriquez.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
<<<<<<< HEAD
@NoArgsConstructor 
public class Solicitud {

=======
@NoArgsConstructor  
public class Solicitud {
    
    @NotNull(message = "El id no puede ser nulo")
>>>>>>> fdd4e13ff2b6e2d96fe8124281f543848fc04a75
    private Long id;

    @NotBlank(message = "El nombre del paciente es obligatorio")
    private String nombrePaciente;

<<<<<<< HEAD
    @NotBlank(message = "El RUT es obligatorio")
    private String rutPaciente;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotNull(message = "La prioridad es obligatoria")
    private Prioridad prioridad;

    private EstadoSolicitud estado;
    private LocalDateTime fechaRegistro;

=======
    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotNull(message = "El estado es obligatorio")
    private EstadoSolicitud estado;

    private LocalDateTime fechaRegistro;

    @NotNull(message = "La prioridad es obligatoria")
    private Prioridad prioridad;
>>>>>>> fdd4e13ff2b6e2d96fe8124281f543848fc04a75
}

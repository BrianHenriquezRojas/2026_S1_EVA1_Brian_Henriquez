package cl.duoc.brianhenriquez.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.brianhenriquez.model.EstadoSolicitud;
import cl.duoc.brianhenriquez.model.Solicitud;
import cl.duoc.brianhenriquez.repository.SolicitudRepository;

@Service
public class SolicitudService {

 
    private final SolicitudRepository repository;

    public SolicitudService(SolicitudRepository repository) {
        this.repository = repository;
    }

    public Solicitud createSolicitud(Solicitud solicitud) {
        solicitud.setFechaRegistro(LocalDateTime.now());
        solicitud.setEstado(EstadoSolicitud.PENDIENTE);
        return repository.guardar(solicitud);
    }

    public List<Solicitud> getAllSolicitudes() {
        return repository.listar();
    }

    public Optional<Solicitud> getSolicitudById(Long id) {
        return repository.buscarPorId(id);
    }

    public Optional<Solicitud> updateSolicitud(Long id, Solicitud solicitud) {
        return repository.actualizar(id, solicitud);
    }

    public boolean deleteSolicitud(Long id) {
        return repository.eliminar(id);
    }

    public List<Solicitud> buscarPorEspecialidad(String especialidad) {
        return repository.listar().stream()
                .filter(s -> s.getEspecialidad().equalsIgnoreCase(especialidad))
                .collect(Collectors.toList());
    }

    public List<Solicitud> ordenarPorPrioridad() {
        return repository.listar().stream()
                .sorted(Comparator.comparing(Solicitud::getPrioridad).reversed())
                .collect(Collectors.toList());
    }

}

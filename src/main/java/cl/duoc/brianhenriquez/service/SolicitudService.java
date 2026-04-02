package cl.duoc.brianhenriquez.service;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
=======
import java.util.List;
import java.util.Optional;
>>>>>>> fdd4e13ff2b6e2d96fe8124281f543848fc04a75

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import cl.duoc.brianhenriquez.model.EstadoSolicitud;
=======
>>>>>>> fdd4e13ff2b6e2d96fe8124281f543848fc04a75
import cl.duoc.brianhenriquez.model.Solicitud;
import cl.duoc.brianhenriquez.repository.SolicitudRepository;

@Service
public class SolicitudService {

<<<<<<< HEAD
 
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
=======
        @Autowired
    private final SolicitudRepository solicitudRepository;

    public SolicitudService(SolicitudRepository solicitudRepository){
        this.solicitudRepository = solicitudRepository;
    }

    public List<Solicitud> getAllSolicituds(){
        return solicitudRepository.findAll();
    }

    public Optional<Solicitud> getSolicitudById(Long id){
        return solicitudRepository.findById(id);
    }

    public Solicitud createSolicitud(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }

    public Optional<Solicitud> updateSolicitud(Long id, Solicitud solicitud){
        if(solicitudRepository.existsById(id)){
            solicitud.setId(id);
            return Optional.of(solicitudRepository.save(solicitud));
        }
        return Optional.empty();
    }

    public boolean deleteSolicitud(Long id){
        if(solicitudRepository.existsById(id)){
            solicitudRepository.deleteById(id);
            return true;
        }
        return false;
>>>>>>> fdd4e13ff2b6e2d96fe8124281f543848fc04a75
    }

}

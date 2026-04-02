package cl.duoc.brianhenriquez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.brianhenriquez.model.Solicitud;
import cl.duoc.brianhenriquez.service.SolicitudService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public ResponseEntity<Solicitud> createSolicitud(@Valid @RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(solicitudService.createSolicitud(solicitud));
    }

    @GetMapping
    public ResponseEntity<List<Solicitud>> getAllSolicitudes() {
        return ResponseEntity.ok(solicitudService.getAllSolicitudes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> getSolicitudById(@PathVariable Long id) {
        return solicitudService.getSolicitudById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> updateSolicitud(@PathVariable Long id,
                                                     @Valid @RequestBody Solicitud solicitud) {
        return solicitudService.updateSolicitud(id, solicitud)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitud(@PathVariable Long id) {
        return solicitudService.deleteSolicitud(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // 🔍 Buscar por especialidad
    @GetMapping("/buscar")
    public ResponseEntity<List<Solicitud>> buscarPorEspecialidad(@RequestParam String especialidad) {
        return ResponseEntity.ok(solicitudService.buscarPorEspecialidad(especialidad));
    }

    // 🔝 Ordenar por prioridad
    @GetMapping("/ordenar/prioridad")
    public ResponseEntity<List<Solicitud>> ordenarPorPrioridad() {
        return ResponseEntity.ok(solicitudService.ordenarPorPrioridad());
    }
}

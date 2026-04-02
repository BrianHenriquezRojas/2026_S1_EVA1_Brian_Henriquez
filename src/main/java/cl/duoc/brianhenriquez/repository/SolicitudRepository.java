package cl.duoc.brianhenriquez.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.duoc.brianhenriquez.model.Solicitud;

@Repository
public class SolicitudRepository {
<<<<<<< HEAD
   private final Map<Long, Solicitud> baseDatos = new HashMap<>();
    private Long contadorId = 1L;

    public Solicitud guardar(Solicitud solicitud) {
        solicitud.setId(contadorId++);
        baseDatos.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    public List<Solicitud> listar() {
        return new ArrayList<>(baseDatos.values());
    }

    public Optional<Solicitud> buscarPorId(Long id) {
        return Optional.ofNullable(baseDatos.get(id));
    }

    public Optional<Solicitud> actualizar(Long id, Solicitud solicitud) {
        if (!baseDatos.containsKey(id)) {
            return Optional.empty();
        }
        solicitud.setId(id);
        baseDatos.put(id, solicitud);
        return Optional.of(solicitud);
    }

    public boolean eliminar(Long id) {
        return baseDatos.remove(id) != null;
=======
    private final Map<Long, Solicitud> solicitudStore = new HashMap<>();

    public List<Solicitud> findAll(){
        return new ArrayList<>(solicitudStore.values());
    }

    public Optional<Solicitud> findById(Long id){
        return Optional.ofNullable(solicitudStore.get(id));
    }

    public Solicitud save(Solicitud solicitud){
        solicitudStore.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    public void deleteById(Long id){
        solicitudStore.remove(id);
    }

    public boolean existsById(Long id){
        return solicitudStore.containsKey(id);
>>>>>>> fdd4e13ff2b6e2d96fe8124281f543848fc04a75
    }

}

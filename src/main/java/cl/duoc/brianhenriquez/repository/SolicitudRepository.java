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
    }

}

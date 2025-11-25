package io.agrisense.ports.out;

import java.util.Optional;
import io.agrisense.domain.model.Sensor;

public interface SensorRepository {

    Optional<Sensor> findById(Long id);

    Optional<Sensor> findByApiKey(String apiKey); 

    Sensor save(Sensor sensor);
}

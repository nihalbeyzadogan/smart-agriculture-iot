package io.agrisense.adapters.out;

import io.agrisense.domain.model.Sensor;
import io.agrisense.ports.out.SensorRepository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class SensorRepositoryImpl implements SensorRepository {

    private final Map<Long, Sensor> sensorsById = new ConcurrentHashMap<>();
    private final Map<String, Sensor> sensorsByApiKey = new ConcurrentHashMap<>();

    @Override
    public Optional<Sensor> findById(Long id) {
        return Optional.ofNullable(sensorsById.get(id));
    }

    @Override
    public Optional<Sensor> findByApiKey(String apiKey) {
        return Optional.ofNullable(sensorsByApiKey.get(apiKey));
    }

    @Override
    public Sensor save(Sensor sensor) {

        // sensörün ID’si yoksa yeni ID ver
        if (sensor.getId() == null) {
            sensor.setId((long) (sensorsById.size() + 1));
        }

        sensorsById.put(sensor.getId(), sensor);

        if (sensor.getApiKey() != null) {
            sensorsByApiKey.put(sensor.getApiKey(), sensor);
        }

        return sensor;
    }
}

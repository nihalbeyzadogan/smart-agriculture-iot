package io.agrisense.adapters.out;

import io.agrisense.domain.model.Measurement;
import io.agrisense.ports.out.MeasurementRepository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class MeasurementRepositoryImpl implements MeasurementRepository {

    // sensorId -> measurements list
    private final ConcurrentHashMap<Long, List<Measurement>> measurements = new ConcurrentHashMap<>();

    @Override
    public void save(Measurement measurement) {

        measurements.computeIfAbsent(
            measurement.getSensorId(),
            id -> new ArrayList<>()
        ).add(measurement);
    }

    @Override
    public List<Measurement> findBySensorId(Long sensorId) {
        return measurements.getOrDefault(sensorId, new ArrayList<>());
    }

    @Override
    public List<Measurement> findAll() {
        return measurements.values()
                           .stream()
                           .collect(ArrayList::new, List::addAll, List::addAll);
    }
}

package io.agrisense.ports.out;

import java.util.List;
import io.agrisense.domain.model.Measurement;

public interface MeasurementRepository {
    void save(Measurement measurement);
    List<Measurement> findBySensorId(Long sensorId);
    List<Measurement> findAll();
}

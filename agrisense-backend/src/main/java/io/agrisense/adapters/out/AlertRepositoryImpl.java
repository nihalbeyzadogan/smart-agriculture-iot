package io.agrisense.adapters.out;

import io.agrisense.domain.model.Alert;
import io.agrisense.ports.out.AlertRepository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class AlertRepositoryImpl implements AlertRepository {

    private final Map<Long, Alert> alerts = new ConcurrentHashMap<>();
    private long currentId = 1L;

    @Override
    public Alert save(Alert alert) {
        if (alert.getId() == null) {
            alert.setId(currentId++);
        }
        alerts.put(alert.getId(), alert);
        return alert;
    }

    @Override
    public Alert findOpenAlert(Long sensorId, Long ruleId) {
        return alerts.values().stream()
                .filter(a -> a.getSensorId().equals(sensorId))
                .filter(a -> a.getRuleId().equals(ruleId))
                .filter(Alert::isOpen)
                .findFirst()
                .orElse(null);
    }
}

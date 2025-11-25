package io.agrisense.ports.out;

import java.util.List;
import java.util.Optional;

import io.agrisense.domain.model.AlertRule;

public interface AlertRuleRepository {
    void save(AlertRule rule);
    List<AlertRule> findActiveBySensorId(Long sensorId);
    List<AlertRule> findAll();
    Optional<AlertRule> findById(Long id);
}

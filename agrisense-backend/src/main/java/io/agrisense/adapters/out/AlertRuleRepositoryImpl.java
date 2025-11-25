package io.agrisense.adapters.out;

import io.agrisense.domain.model.AlertRule;
import io.agrisense.ports.out.AlertRuleRepository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@ApplicationScoped
public class AlertRuleRepositoryImpl implements AlertRuleRepository {

    private final ConcurrentHashMap<Long, AlertRule> rules = new ConcurrentHashMap<>();
    private long currentId = 1L;

    @Override
    public void save(AlertRule rule) {
        if (rule.getId() == null) {
            rule.setId(currentId++);
        }
        rules.put(rule.getId(), rule);
    }

    @Override
    public List<AlertRule> findActiveBySensorId(Long sensorId) {
        return rules.values().stream()
                .filter(rule -> rule.isActive() && rule.getSensorId().equals(sensorId))
                .collect(Collectors.toList());
    }

    @Override
    public List<AlertRule> findAll() {
        return new ArrayList<>(rules.values());
    }

    @Override
    public Optional<AlertRule> findById(Long id) {
        return Optional.ofNullable(rules.get(id));
    }
}

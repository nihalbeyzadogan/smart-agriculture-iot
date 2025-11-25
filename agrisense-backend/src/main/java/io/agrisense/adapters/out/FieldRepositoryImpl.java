package io.agrisense.adapters.out;

import io.agrisense.domain.model.Field;
import io.agrisense.ports.out.FieldRepository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class FieldRepositoryImpl implements FieldRepository {

    private final Map<Long, Field> fields = new ConcurrentHashMap<>();
    private long currentId = 1L;

    @Override
    public Field save(Field field) {
        if (field.getId() == null) {
            field.setId(currentId++);
        }
        fields.put(field.getId(), field);
        return field;
    }

    @Override
    public Field findById(Long id) {
        return fields.get(id);
    }

    @Override
    public List<Field> findByFarmerId(Long farmerId) {
        List<Field> result = new ArrayList<>();
        for (Field f : fields.values()) {
            if (f.getFarmerId().equals(farmerId)) {
                result.add(f);
            }
        }
        return result;
    }
}

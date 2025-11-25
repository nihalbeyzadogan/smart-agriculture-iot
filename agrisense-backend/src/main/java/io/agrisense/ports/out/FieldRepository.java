package io.agrisense.ports.out;
import java.util.List;       
import io.agrisense.domain.model.Field;
public interface FieldRepository {
    Field save(Field field);
    Field findById(Long id);
    List<Field> findByFarmerId(Long farmerId);
}

package io.agrisense.ports.out;
import io.agrisense.domain.model.Farmer;

public interface FarmerRepository {
    Farmer save(Farmer farmer);
    Farmer findById(Long id);
    Farmer findByEmail(String email);
}

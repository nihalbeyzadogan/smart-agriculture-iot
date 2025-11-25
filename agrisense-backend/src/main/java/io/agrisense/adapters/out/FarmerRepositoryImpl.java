package io.agrisense.adapters.out;

import io.agrisense.domain.model.Farmer;
import io.agrisense.ports.out.FarmerRepository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class FarmerRepositoryImpl implements FarmerRepository {

    private final Map<Long, Farmer> farmers = new ConcurrentHashMap<>();
    private final Map<String, Farmer> farmersByEmail = new ConcurrentHashMap<>();
    private long currentId = 1L;

    @Override
    public Farmer save(Farmer farmer) {
        if (farmer.getId() == null) {
            farmer.setId(currentId++);
        }
        farmers.put(farmer.getId(), farmer);
        farmersByEmail.put(farmer.getEmail(), farmer);
        return farmer;
    }

    @Override
    public Farmer findById(Long id) {
        return farmers.get(id);
    }

    @Override
    public Farmer findByEmail(String email) {
        return farmersByEmail.get(email);
    }
}

package io.agrisense.ports.in;

public interface ProcessMeasurementUseCase {
    void processMeasurement(String apiKey, double value, String unit);
}
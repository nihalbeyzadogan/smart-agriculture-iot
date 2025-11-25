package io.agrisense.domain.model;

import java.util.List;

public class Field {

    private Long id;
    private String name;
    private String location;

    private Long farmerId;
    private List<Sensor> sensors;

    public Field(Long id, String name, String location, Long farmerId, List<Sensor> sensors) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.farmerId = farmerId;
        this.sensors = sensors;
    }

    public Long getId() { return id; }
    public void setId(Long id){
        this.id=id;
    }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public Long getFarmerId() { return farmerId; }
    public List<Sensor> getSensors() { return sensors; }
}

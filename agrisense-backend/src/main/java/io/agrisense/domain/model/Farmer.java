package io.agrisense.domain.model;

import java.util.List;

public class Farmer {

    private Long id;
    private String name;
    private String email;
    private String passwordHash;

    private List<Field> fields;

    public Farmer(Long id, String name, String email, String passwordHash, List<Field> fields) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.fields = fields;
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName() { 
        return name; 
    }
    public String getEmail() { 
        return email; 
    }
    public String getPasswordHash() { 
        return passwordHash; 
    }
    public List<Field> getFields() { 
        return fields; 
    }
}
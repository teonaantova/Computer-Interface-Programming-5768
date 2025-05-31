package org.example.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private String team;
    private String mentor;

    public Employee() {
    }

    public Employee(String name, String status, String team, String mentor) {
        this.name = name;
        this.status = status;
        this.team = team;
        this.mentor = mentor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }
    public String getMentor() { return mentor; }
    public void setMentor(String mentor) { this.mentor = mentor; }
}


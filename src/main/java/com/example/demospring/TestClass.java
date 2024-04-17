package com.example.demospring;

import jakarta.persistence.*;

@Entity
@Table
public class TestClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "test_name")
    private String name;

    @Column(name = "tt")
    private String yy;

    public TestClass(int id, String name, String yy) {
        this.id = id;
        this.name = name;
        this.yy = yy;
    }

    public String getYy() {
        return yy;
    }

    public void setYy(String yy) {
        this.yy = yy;
    }

    public TestClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

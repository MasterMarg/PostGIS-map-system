package com.cit.PostGISmapsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CircleGeometry {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private Double[] center;
    private double radius;

    public CircleGeometry() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double[] getCenter() {
        return center;
    }

    public void setCenter(Double[] center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

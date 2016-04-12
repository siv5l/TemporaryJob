package com.endava.siv5l.model;

import javax.persistence.*;

/**
 * Created by siv5l on 4/11/16.
 */
@Entity
@Table(name="Location")
public class Location {

    @Id
    @Column(name="location_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long locationId;

    @Column(name="name")
    private String name;

    @Column(name="zip_code")
    private int zipCode;

    public Location(){}

    public Location(long locationId, String name, int zipCode) {
        this.locationId = locationId;
        this.name = name;
        this.zipCode = zipCode;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
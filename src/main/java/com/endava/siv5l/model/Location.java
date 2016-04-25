package com.endava.siv5l.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Location",
            joinColumns = {@JoinColumn(name = "location_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> locationUsers = new ArrayList<User>();


    public Location(){
    }

    public Location(String name, int zipCode, List<User> locationUsers) {
        this.name = name;
        this.zipCode = zipCode;
        this.locationUsers = locationUsers;
    }


    public List<User> getLocationUsers() {
        return locationUsers;
    }

    public void setLocationUsers(List<User> locationUsers) {
        this.locationUsers = locationUsers;
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

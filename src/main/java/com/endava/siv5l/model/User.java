package com.endava.siv5l.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by siv5l on 4/3/16.
 */
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String username;
    @Column
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Location",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "location_id")})
    private List<Location> userLocations = new ArrayList<Location>();

    @Transient
    private List<String> locations = new ArrayList<String>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Category",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> userCategories = new ArrayList<Category>();

    @Transient
    private List<String> categories = new ArrayList<String>();

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "user")
    @JoinColumn(name = "user_id")
    private List<Announcement> announcementsList = new ArrayList<Announcement>();

    public User(){
    }

    public User(String firstName, String lastName, String username, String password, List<Location> userLocations,
                List<String> locations, List<Category> userCategories, List<String> categories, List<Announcement> announcementsList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userLocations = userLocations;
        this.locations = locations;
        this.userCategories = userCategories;
        this.categories = categories;
        this.announcementsList = announcementsList;
    }

    public List<Announcement> getAnnouncementsList() {
        return announcementsList;
    }

    public void setAnnouncementsList(List<Announcement> announcementsList) {
        this.announcementsList = announcementsList;
    }

    public List<Category> getUserCategories() {
        return userCategories;
    }

    public void setUserCategories(List<Category> userCategories) {
        this.userCategories = userCategories;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Location> getUserLocations() {
        return userLocations;
    }

    public void setUserLocations(List<Location> userLocations) {
        this.userLocations = userLocations;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

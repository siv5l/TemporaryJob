package com.endava.siv5l.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
@Entity
@Table(name = "Announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "announcement_id")
    private long announcementId;
    @Column(name = "subject")
    private String subject;
    @Column(name = "description")
    private String description;

    @Column(name = "posted_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="Announcement_Location_T",
            joinColumns = {@JoinColumn(name="announcement_id")},
            inverseJoinColumns = {@JoinColumn(name="location_id")})
    private List<Location> locationList = new ArrayList<Location>();

    @Transient
    private List<String> locations = new ArrayList<String>();

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="Announcement_Category_T",
            joinColumns = {@JoinColumn(name="announcement_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    private List<Category> categoryList = new ArrayList<Category>();

    @Transient
    private List<String> categories = new ArrayList<String>();

    public Announcement(){}

    public Announcement(String subject, String description, Date date, List<Location> locationList, User user, List<String> locations, List<Category> categoryList, List<String> categories) {
        this.subject = subject;
        this.description = description;
        this.date = date;
        this.locationList = locationList;
        this.user = user;
        this.locations = locations;
        this.categoryList = categoryList;
        this.categories = categories;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(long announcementId) {
        this.announcementId = announcementId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

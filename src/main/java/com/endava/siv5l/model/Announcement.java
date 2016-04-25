package com.endava.siv5l.model;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;


    public Announcement(){}

    public Announcement(String subject, String description, User user) {
        this.subject = subject;
        this.description = description;
        this.user = user;
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

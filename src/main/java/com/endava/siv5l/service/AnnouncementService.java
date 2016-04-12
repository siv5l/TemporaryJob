package com.endava.siv5l.service;

import com.endava.siv5l.model.Announcement;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
public interface AnnouncementService {
    public void add(Announcement announcement);
    public void edit(Announcement announcement);
    public void delete(int announcementId);
    public Announcement getAnnouncement(int announcementId);
    public List getAllAnnouncements();
}

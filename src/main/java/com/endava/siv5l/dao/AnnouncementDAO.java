package com.endava.siv5l.dao;

import com.endava.siv5l.model.Announcement;
import com.endava.siv5l.model.Category;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
public interface AnnouncementDAO {
    public void add(Announcement announcement);
    public void edit(Announcement announcement);
    public void delete(int announcementId);
    public Announcement getAnnouncement(int announcementId);
    public List getAllAnnouncements();
}

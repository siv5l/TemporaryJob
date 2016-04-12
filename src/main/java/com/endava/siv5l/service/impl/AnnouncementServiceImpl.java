package com.endava.siv5l.service.impl;

import com.endava.siv5l.dao.AnnouncementDAO;
import com.endava.siv5l.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDAO announcementDAO;

    @Transactional
    public void add(Announcement announcement) {
        announcementDAO.add(announcement);
    }

    @Transactional
    public void edit(Announcement announcement) {
        announcementDAO.edit(announcement);
    }

    @Transactional
    public void delete(int announcementId) {
        announcementDAO.delete(announcementId);
    }

    @Transactional
    public Announcement getAnnouncement(int announcementId) {
        return announcementDAO.getAnnouncement(announcementId);
    }

    @Transactional
    public List getAllAnnouncements() {
        return announcementDAO.getAllAnnouncements();
    }
}

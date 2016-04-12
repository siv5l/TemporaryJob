package com.endava.siv5l.dao.impl;

import com.endava.siv5l.dao.AnnouncementDAO;
import com.endava.siv5l.model.Announcement;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
@Repository
public class AnnouncementDAOImpl implements AnnouncementDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Announcement announcement) {
        sessionFactory.getCurrentSession().save(announcement);
    }

    @Override
    public void edit(Announcement announcement) {
        sessionFactory.getCurrentSession().update(announcement);
    }

    @Override
    public void delete(int announcementId) {
        sessionFactory.getCurrentSession().delete(getAnnouncement(announcementId));
    }

    @Override
    public Announcement getAnnouncement(int announcementId) {
        return (Announcement) sessionFactory.getCurrentSession().get(Announcement.class, announcementId);
    }

    @Override
    public List getAllAnnouncements() {
        return sessionFactory.getCurrentSession().createQuery("FROM Announcement").list();
    }
}

package com.endava.siv5l.dao.impl;

import com.endava.siv5l.dao.AnnouncementDAO;
import com.endava.siv5l.model.Announcement;
import com.endava.siv5l.model.User;
import org.hibernate.Query;
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

    public List getAllMyAnnouncements(long id){
        return sessionFactory.getCurrentSession().createQuery("From Announcement e WHERE e.user.userId = :e").setParameter("e",id).list();
    }

    @Override
    public List getAnnouncementJoinCategoryLocation(String locatie, String categorie) {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT Announcement.announcement_id, Announcement.subject, Announcement.description, Announcement.user_id, Announcement.posted_date\n" +
                "FROM Announcement\n" +
                "INNER JOIN Announcement_Category_T ON Announcement.announcement_id = Announcement_Category_T.announcement_id\n" +
                "INNER JOIN Category ON Announcement_Category_T.category_id = Category.category_id\n" +
                "INNER JOIN Announcement_Location_T ON Announcement.announcement_id = Announcement_Location_T.announcement_id\n" +
                "INNER JOIN Location ON Announcement_Location_T.location_id = Location.location_id\n" +
                "WHERE Category.name = :categorie AND Location.name = :locatie ").addEntity(Announcement.class).setParameter("locatie", locatie).setParameter("categorie",categorie).list();
    }

    @Override
    public List getAnnouncementJoinCategory(String category) {
        return sessionFactory.getCurrentSession().createQuery("from Announcement a join a.categoryList c where c.name =:category").setParameter("category",category).list();
    }

    @Override
    public List getAnnouncementJoinLocation(String location) {
        return sessionFactory.getCurrentSession().createQuery("from Announcement a join a.locationList l where l.name =:location").setParameter("location",location).list();
    }
}

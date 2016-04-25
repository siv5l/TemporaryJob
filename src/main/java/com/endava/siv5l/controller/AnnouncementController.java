package com.endava.siv5l.controller;

import com.endava.siv5l.model.Announcement;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.AnnouncementService;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by siv5l on 4/25/16.
 */

@Controller
public class AnnouncementController {
    @Autowired
    private UserService userService;
    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping(value = "/addannouncement")
    public @ResponseBody String addingAnnouncements(ModelMap model,HttpSession httpSession){

        User user = (User) httpSession.getAttribute("userAccount");

        User currentUser = userService.getUser(user.getUserId());
        Announcement announcementOne = new Announcement();
        announcementOne.setSubject("firstSubject");
        announcementOne.setDescription("firstDescription");

        Announcement announcementTwo = new Announcement();
        announcementTwo.setSubject("SecondSubject");
        announcementTwo.setDescription("SecondDescription");

        currentUser.getAnnouncementsList().add(announcementOne);
        currentUser.getAnnouncementsList().add(announcementTwo);
        announcementOne.setUser(currentUser);
        announcementTwo.setUser(currentUser);
        announcementService.add(announcementOne);
        announcementService.add(announcementTwo);
        return "abrakadabra";
    }

}

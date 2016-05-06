package com.endava.siv5l.controller;

import com.endava.siv5l.model.Announcement;
import com.endava.siv5l.model.Category;
import com.endava.siv5l.model.Location;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.AnnouncementService;
import com.endava.siv5l.service.CategoryService;
import com.endava.siv5l.service.LocationService;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by siv5l on 4/25/16.
 */

@Controller
public class AnnouncementController {
    @Autowired
    private UserService userService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/addannouncement", method = RequestMethod.GET)
    public String addingAnnouncment(ModelMap model){
        Announcement announcement = new Announcement();
        model.addAttribute("announcement",announcement);
        return "menu/addannouncement";
    }

    @RequestMapping(value = "/addannouncement", method = RequestMethod.POST)
    public String addingAnnouncements(@ModelAttribute Announcement announcement,BindingResult result,
                                                    HttpSession httpSession, ModelMap model){
        User user = (User) httpSession.getAttribute("userAccount");

        List<String> locations = announcement.getLocations(); //fac bind la localitatile in care va fi pus anuntul
        List<String> categories = announcement.getCategories(); //fac bind la categoriile in care va fi pus anuntul

        if(announcement.getLocations() != null){
            for (String location : locations) {
                Location l = locationService.getByName(location);
                announcement.getLocationList().add(l); // anuntul poate fi postat pe mai multe localitati
            }
        }
        if(announcement.getCategories() != null) {
            for (String category : categories) {
                Category c = categoryService.getByName(category);
                announcement.getCategoryList().add(c); // anuntul poate fi postat pe mai multe categorii
            }
        }


        User currentUser = userService.getUser(user.getUserId());
        currentUser.getAnnouncementsList().add(announcement);  // un utilizator poate posta mai multe anunturi
        announcement.setUser(currentUser);  // trebuie sa se cunoasca de cine este postat acest anunt
        announcement.setDate(new Date());

        announcementService.add(announcement); //salvez anuntul care are un utilizator, si este postat in mai multe localitati si categorii

        return "log/logged";
    }

    @RequestMapping(value="/{username}/announcements", method = RequestMethod.GET)
    public String  returnAnnouncements(@PathVariable("username") String username,HttpSession session,ModelMap model){

        User user = (User) session.getAttribute("userAccount");
        List<Announcement> announcements = announcementService.getAllMyAnnouncements(user.getUserId());
        model.addAttribute("anunturi",announcements);
        return "profile/showMyAnnouncements";
    }

}

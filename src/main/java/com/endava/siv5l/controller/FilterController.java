package com.endava.siv5l.controller;

import com.endava.siv5l.model.Announcement;
import com.endava.siv5l.model.Category;
import com.endava.siv5l.model.Location;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.AnnouncementService;
import com.endava.siv5l.service.CategoryService;
import com.endava.siv5l.service.UserService;
import com.endava.siv5l.service.filter.FilterQuery;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.*;


@Controller
public class FilterController {
    @Autowired
    private UserService userService;
    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping(value = "/submitfilter", method = RequestMethod.POST)
    public String submitfilterQuery(@Valid @ModelAttribute("filterQuery") FilterQuery filterQuery, BindingResult result,
                                     ModelMap model){
        List<User> filterUsers = new ArrayList<User>();
        List<Announcement> filterAnnouncements = new ArrayList<Announcement>();
        try {
            if (filterQuery.getOption().equals("unnemployed")) { // daca bifeaza radio butonul someri
                if (filterQuery.getCategory() != null && filterQuery.getLocation() != null) {  //daca am ales si categoria si localitatea
                    System.out.println("0");
                    filterUsers = userService.getUsersJoinCategoryLocation(filterQuery.getLocation(), filterQuery.getCategory());
                }
                else if (filterQuery.getCategory() != null && filterQuery.getLocation() == null) {  // daca am ales doar categoria
                    System.out.println("1");
                    List<Object[]> list = (List<Object[]>) userService.getUsersJoinCategory(filterQuery.getCategory());
                    System.out.println("Size " + list.size());
                    for (Object[] u : list) {
                        User user = (User) u[0];
                        /*Category category = (Category) u[1];*/
                        filterUsers.add(user);
                    }
                }
                else if (filterQuery.getCategory() == null && filterQuery.getLocation() != null) { //daca am ales doar localitatea
                    System.out.println("2");
                    List<Object[]> list = (List<Object[]>) userService.getUsersJoinLocation(filterQuery.getLocation());
                    System.out.println("Size " + list.size());
                    for (Object[] u : list) {
                        User user = (User) u[0];
                        /*Location location = (Location) u[1];*/
                        filterUsers.add(user);
                    }
                }
                else { //daca nu am ales nimic
                    System.out.println("3");
                    filterUsers = userService.getAllUsers();
                }
                model.addAttribute("filterUsers",filterUsers);
                return "filterusers";
            }
            else if(filterQuery.getOption().equals("announcement")){ // daca bifeaza radio butonul anunturi
                if (filterQuery.getCategory() != null && filterQuery.getLocation() != null) {  //daca am ales si categoria si localitatea
                    System.out.println("4");
                    List<Announcement> list = announcementService.getAnnouncementJoinCategoryLocation(filterQuery.getLocation(),filterQuery.getCategory());
                    filterAnnouncements = list;
                    for(Announcement a : list){
                         User user = a.getUser();
                         System.out.println(user.getFirstName());
                    }
                }
                else if (filterQuery.getCategory() != null && filterQuery.getLocation() == null) {  // daca am ales doar categoria
                    System.out.println("5");
                    List<Object[]> list = (List<Object[]>) announcementService.getAnnouncementJoinCategory(filterQuery.getCategory());
                    System.out.println("Size " + list.size());
                    for (Object[] a : list) {
                        Announcement announcement = (Announcement) a[0];
                        filterAnnouncements.add(announcement);
                    }
                }
                else if (filterQuery.getCategory() == null && filterQuery.getLocation() != null) { //daca am ales doar localitatea
                    System.out.println("6");
                    List<Object[]> list = (List<Object[]>) announcementService.getAnnouncementJoinLocation(filterQuery.getLocation());
                    System.out.println("Size " + list.size());
                    for (Object[] a : list) {
                        Announcement announcement = (Announcement) a[0];
                        filterAnnouncements.add(announcement);
                    }
                }
                else { //daca nu am ales nimic
                    System.out.println("7");
                    filterAnnouncements = announcementService.getAllAnnouncements();
                }
                model.addAttribute("anunturi",filterAnnouncements);
                return "globalannouncements";
            }
        }catch (NullPointerException e){
            return "signin";
        }

        return "signin";
    }
}

package com.endava.siv5l.controller.filter;

import com.endava.siv5l.model.Announcement;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.AnnouncementService;
import com.endava.siv5l.service.UserService;
import com.endava.siv5l.service.filter.FilterQuery;
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
                    filterUsers = userService.getUsersJoinCategoryLocation(filterQuery.getLocation(), filterQuery.getCategory());
                }
                else if (filterQuery.getCategory() != null && filterQuery.getLocation() == null) {  // daca am ales doar categoria
                    List<Object[]> list = (List<Object[]>) userService.getUsersJoinCategory(filterQuery.getCategory());
                    System.out.println("Size " + list.size());
                    for (Object[] u : list) {
                        User user = (User) u[0];
                        /*Category category = (Category) u[1];*/
                        filterUsers.add(user);
                    }
                }
                else if (filterQuery.getCategory() == null && filterQuery.getLocation() != null) { //daca am ales doar localitatea
                    List<Object[]> list = (List<Object[]>) userService.getUsersJoinLocation(filterQuery.getLocation());
                    System.out.println("Size " + list.size());
                    for (Object[] u : list) {
                        User user = (User) u[0];
                        /*Location location = (Location) u[1];*/
                        filterUsers.add(user);
                    }
                }
                else { //daca nu am ales nimic
                    filterUsers = userService.getAllUsers();
                }
                model.addAttribute("filterUsers",filterUsers);
                return "filter/showAllFilterUsers";
            }
            else if(filterQuery.getOption().equals("announcement")){ // daca bifeaza radio butonul anunturi
                if (filterQuery.getCategory() != null && filterQuery.getLocation() != null) {  //daca am ales si categoria si localitatea
                    List<Announcement> list = announcementService.getAnnouncementJoinCategoryLocation(filterQuery.getLocation(),filterQuery.getCategory());
                    filterAnnouncements = list;
                    for(Announcement a : list){
                         User user = a.getUser();
                         System.out.println(user.getFirstName());
                    }
                }
                else if (filterQuery.getCategory() != null && filterQuery.getLocation() == null) {  // daca am ales doar categoria
                    List<Object[]> list = (List<Object[]>) announcementService.getAnnouncementJoinCategory(filterQuery.getCategory());
                    System.out.println("Size " + list.size());
                    for (Object[] a : list) {
                        Announcement announcement = (Announcement) a[0];
                        filterAnnouncements.add(announcement);
                    }
                }
                else if (filterQuery.getCategory() == null && filterQuery.getLocation() != null) { //daca am ales doar localitatea
                    List<Object[]> list = (List<Object[]>) announcementService.getAnnouncementJoinLocation(filterQuery.getLocation());
                    System.out.println("Size " + list.size());
                    for (Object[] a : list) {
                        Announcement announcement = (Announcement) a[0];
                        filterAnnouncements.add(announcement);
                    }
                }
                else { //daca nu am ales nimic
                    filterAnnouncements = announcementService.getAllAnnouncements();
                }
                model.addAttribute("anunturi",filterAnnouncements);
                return "filter/showAllFilterAnnouncements";
            }
        }catch (NullPointerException e){
            return "log/unlogged";
        }

        return "log/unlogged";
    }
}

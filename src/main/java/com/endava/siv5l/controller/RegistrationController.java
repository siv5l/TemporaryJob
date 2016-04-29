package com.endava.siv5l.controller;

import com.endava.siv5l.model.Category;
import com.endava.siv5l.model.Location;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.CategoryService;
import com.endava.siv5l.service.LocationService;
import com.endava.siv5l.service.UserService;
import com.endava.siv5l.service.messaging.Message;
import com.endava.siv5l.service.messaging.MessageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by siv5l on 4/4/16.
 */
@Controller
@SessionAttributes("userAccount")
public class RegistrationController {

    @Autowired
    UserService userService;
    @Autowired
    LocationService locationService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    private MessageMap messageMap;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView inregistrare(){
        ModelAndView mav = new ModelAndView("registration");
        User user = new User();
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping(value = "/submitregistration", method = RequestMethod.POST)
    public String inregistrare(@ModelAttribute User user, BindingResult result,ModelMap map){
        System.out.println(user.getFirstName());
        List<String> loc = user.getLocations();
        List<String> cat = user.getCategories();

        if(loc != null) {
            for (String l : loc) {
                Location a = locationService.getByName(l);
                user.getUserLocations().add(a); //un utilizator poate functiona in mai multe localitati, ManyToMany
            }
        }
        if(cat != null) {
            for (String c : cat) {
                Category a = categoryService.getByName(c);
                user.getUserCategories().add(a); //un utilizator poate functiona in mai multe categorii, ManyToMany
            }
        }

        userService.add(user); // persist utilizatorul care are se afla in mai multe categorii si localitati
        messageMap.getMapa().put(user.getUsername(),new HashMap<String, ArrayList<Message>>()); // adaug utilizatorul nou
                                                                        // in mapa cu mesaje
        map.addAttribute("userAccount",user);

        return "logged";
    }

    @RequestMapping(value = "/submitregistration", method = RequestMethod.GET)
    public String loggedRegistration(ModelMap map){
        return "logged";
    }
}

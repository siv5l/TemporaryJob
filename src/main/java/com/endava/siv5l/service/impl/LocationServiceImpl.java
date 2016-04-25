package com.endava.siv5l.service.impl;

import com.endava.siv5l.dao.LocationDAO;
import com.endava.siv5l.model.Location;
import com.endava.siv5l.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDAO locationDAO;

    @Transactional
    public void add(Location location) {
        locationDAO.add(location);
    }

    @Transactional
    public void edit(Location location) {
        locationDAO.edit(location);
    }

    @Transactional
    public void delete(int locationId) {
        locationDAO.delete(locationId);
    }

    @Transactional
    public Location getLocation(int locationId) {
        return locationDAO.getLocation(locationId);
    }

    @Transactional
    public List getAllLocations() {
        return locationDAO.getAllLocations();
    }

    @Transactional
    public Location getByName(String name){
        return locationDAO.getByName(name);
    }
}

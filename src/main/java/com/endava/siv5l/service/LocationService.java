package com.endava.siv5l.service;

import com.endava.siv5l.model.Location;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
public interface LocationService {
    public void add(Location location);
    public void edit(Location location);
    public void delete(int locationId);
    public Location getLocation(int locationId);
    public List getAllLocations();
    public Location getByName(String name);
}

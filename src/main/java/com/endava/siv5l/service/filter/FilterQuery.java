package com.endava.siv5l.service.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siv5l on 4/26/16.
 */
public class FilterQuery {
    private String category;
    private String location;
    private String option;

    public FilterQuery() {}

    public FilterQuery(String category, String location, String option) {
        this.category = category;
        this.location = location;
        this.option = option;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}

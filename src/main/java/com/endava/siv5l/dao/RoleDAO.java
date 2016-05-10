package com.endava.siv5l.dao;

import com.endava.siv5l.model.Role;

import java.util.List;

/**
 * Created by siv5l on 5/6/16.
 */
public interface RoleDAO {
    public void add(Role role);
    public void edit(Role role);
    public void delete(long roleId);
    public Role getRole(long roleId);
    public List getAllRoles();
}

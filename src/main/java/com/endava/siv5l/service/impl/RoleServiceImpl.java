package com.endava.siv5l.service.impl;

import com.endava.siv5l.dao.RoleDAO;
import com.endava.siv5l.model.Role;
import com.endava.siv5l.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siv5l on 5/6/16.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Transactional
    public void edit(Role role) {
        roleDAO.edit(role);
    }

    @Transactional
    public void delete(long roleId) {
        roleDAO.delete(roleId);
    }

    @Transactional
    public Role getRole(long roleId) {
        return roleDAO.getRole(roleId);
    }

    @Transactional
    public List getAllRoles() {
        return roleDAO.getAllRoles();
    }
}

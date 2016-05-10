package com.endava.siv5l.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by siv5l on 5/6/16.
 */
@Entity
@Table(name = "Role")
public class Role implements Serializable {
    @Id
    @Column(name = "User_Role_Id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long roleId;
    @Column(name = "authority")
    private String authority;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    @JoinColumn(name= "user_role_id")
    private Set<User> usersList = new HashSet<User>();


    public Role(){}

    public Role(String authority, Set<User> usersList) {
        this.authority = authority;
        this.usersList = usersList;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(Set<User> usersList) {
        this.usersList = usersList;
    }
}

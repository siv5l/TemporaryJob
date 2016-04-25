package com.endava.siv5l.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
@Entity
@Table(name="Category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long categoryId;
    @Column(name="name")
    private String name;
    @Column(name="descriere")
    private String descriere;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Category",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> categoryUsers = new ArrayList<User>();



    public Category(){}

    public Category(String name, String descriere, List<User> categoryUsers) {
        this.name = name;
        this.descriere = descriere;
        this.categoryUsers = categoryUsers;
    }

    public List<User> getCategoryUsers() {
        return categoryUsers;
    }

    public void setCategoryUsers(List<User> categoryUsers) {
        this.categoryUsers = categoryUsers;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

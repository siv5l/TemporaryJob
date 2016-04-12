package com.endava.siv5l.model;

import javax.persistence.*;

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


    public Category(){}

    public Category(long categoryId, String name, String descriere){
        this.categoryId = categoryId;
        this.name = name;
        this.descriere = descriere;
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

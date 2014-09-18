package com.mypitech.experior.jersey2.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Shawn Wheeler on 9/13/2014.
 */
@Entity
@Table(name = "test_user", schema = "data")
public class UserEntity extends EntitySuperClass{
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

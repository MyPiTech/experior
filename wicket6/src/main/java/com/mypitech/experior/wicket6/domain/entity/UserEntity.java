package com.mypitech.experior.wicket6.domain.entity;

import javax.persistence.*;

/**
 * Created by Shawn Wheeler on 9/13/2014.
 */
@NamedQueries({
        @NamedQuery(name = "UserEntity.all", query = "SELECT ue FROM UserEntity ue ORDER BY ue.name")
})
@Entity
@Table(name = "test_user", schema = "data")
public class UserEntity extends com.mypitech.experior.wicket6.domain.entity.EntitySuperClass {
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

/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.wicket6.domain.entity;


import com.fasterxml.uuid.Generators;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The EntitySuperClass populates the metadata for all entities.
 * <p/>
 * Created by Shawn Wheeler on 5/21/2014.
 */

@MappedSuperclass
public class EntitySuperClass {

    @Id
    @Column(name = "identity")
    private String identity;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "updated")
    private Timestamp updated;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @PrePersist
    private void preInsert() {
        Timestamp insertTime = new Timestamp(new DateTime(DateTimeZone.UTC).getMillis());
        this.created = insertTime;
        this.updated = insertTime;
        this.identity = Generators.timeBasedGenerator().generate().toString();
    }

    @PreUpdate
    private void preUpdate() {
        Timestamp updateTime = new Timestamp(new DateTime(DateTimeZone.UTC).getMillis());
        this.updated = updateTime;
    }
}
